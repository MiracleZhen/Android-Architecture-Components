package com.ling.coroutine.type01.p3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P03Case06Binding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn

/**
 * author : wangchengzhen
 * time   : 2022/7/4
 * desc   : Kotlin 协程 （十七） ——— SharedFlow 简介
 * blog   : https://juejin.cn/post/7091306876431761415
 */
class Case06Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、通过 SharedFlow 实现广播
     * 二、通过 replay 指定保留多少粘性数据
     * 三、SharedFlow 的缓存区
     * 四、通过 shareIn 将冷流转换成 SharedFlow
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P03Case06Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
        binding.btnTest4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> test01()
            R.id.btn_test2 -> test02()
            R.id.btn_test3 -> test03()
            R.id.btn_test4 -> test04()
        }
    }

    /**
     * 通过 SharedFlow 实现广播
     */
    private fun test01() = runBlocking {
        val data = MutableSharedFlow<Int>()
        val job1 = launch {
            data.collect {
                println("first : received $it")
            }
        }
        val job2 = launch {
            data.collect {
                println("second : received $it")
            }
        }
        delay(1000)
        data.emit(1)
        delay(1000)
        job1.cancel()
        job2.cancel()
    }

    /**
     * 通过 replay 指定保留多少粘性数据
     */
    private fun test02() = runBlocking {
        val data = MutableSharedFlow<Int>(2)
        data.emit(1)
        data.emit(2)
        val job1 = launch {
            data.collect {
                println("first : received $it")
            }
        }
        val job2 = launch {
            data.collect {
                println("second: received $it")
            }
        }
        delay(1000)
        job1.cancel()
        job2.cancel()
    }

    /**
     * SharedFlow 的缓存区
     */
    private fun test03() = runBlocking {
        val data = MutableSharedFlow<Int>(0, 2, BufferOverflow.SUSPEND)
        val job1 = launch {
            data.collect {
                delay(200)
                println("received $it")
            }
        }
        launch {
            repeat(5) {
                println("emit: $it")
                data.emit(it)
                println("$it emitted")
            }
        }
        delay(2000)
        job1.cancel()
    }

    /**
     * 通过 shareIn 将冷流转换成 SharedFlow
     */
    private fun test04() = runBlocking {
        val flow = flow {
            var i = 0
            while (true) {
                delay(200)
                println("emit $i")
                emit(i++)
            }
        }
        val sharedFlow = flow.shareIn(
            CoroutineScope(Dispatchers.IO),
            SharingStarted.Eagerly,
            0
        )
        val job = launch {
            delay(1000)
            println("subscribe")
            sharedFlow.collect {
                println("received $it")
            }
        }
        delay(2000)
        job.cancel()
        println("cancel")
        delay(2000)
        println("done")
    }
}
