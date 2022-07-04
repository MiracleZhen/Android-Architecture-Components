package com.ling.coroutine.type01.p2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P02Case01Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * author : wangchengzhen
 * time   : 2022/7/3
 * desc   : Kotlin 协程 （八） ——— Flow 简介
 * blog   : https://juejin.cn/post/7087970291862732830
 */
class Case01Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、Flow 的创建
     * 二、Flow 的生命周期
     * 三、Flow 上下文切换
     * 四、Flow 的取消
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P02Case01Binding.inflate(layoutInflater)
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
     * Flow 的创建
     */
    private fun test01() = runBlocking {
        flow {
            repeat(3) {
                delay(1000)
                emit(it)
            }
        }.collect {
            println(it)
        }
    }

    /**
     * Flow 的生命周期
     */
    private fun test02() = runBlocking {
        flow {
            for (i in 1..5) {
                delay(1000)
                emit(i)
            }
        }.onStart {
            println("onStart")
        }.onCompletion {
            println("onCompletion")
        }.collect {
            println(it)
        }
    }

    /**
     * Flow 上下文切换
     */
    private fun test03() = runBlocking {
        flow {
            println("start: ${Thread.currentThread().name}")
            repeat(3) {
                delay(1000)
                emit(it)
            }
            println("end: ${Thread.currentThread().name}")
        }.flowOn(Dispatchers.Default).collect {
            println("collect: $it, ${Thread.currentThread().name}")
        }
    }

    /**
     * Flow 的取消
     */
    private fun test04() {
        runBlocking {
            flow {
                (1..5).forEach {
                    emit(it)
                }
            }.collect {
                println(it)
                if (it == 3) cancel()
            }
        }

        runBlocking {
            (1..5).asFlow().collect {
                println(it)
                if (it == 3) cancel()
            }
        }

        runBlocking {
            flow {
                (1..5).forEach {
                    emit(it)
                }
            }.cancellable().collect {
                println(it)
                if (it == 3) cancel()
            }
        }
    }
}
