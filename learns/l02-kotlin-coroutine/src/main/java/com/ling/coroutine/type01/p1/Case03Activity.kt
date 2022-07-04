package com.ling.coroutine.type01.p1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P01Case03Binding
import kotlinx.coroutines.*

/**
 * author : wangchengzhen
 * time   : 2022/6/30
 * desc   : Kotlin 协程 （三）——— 启动模式
 * blog   : https://juejin.cn/post/7086106055352483870
 */
class Case03Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、协程的启动模式：CoroutineStart
     * 二、默认启动模式：DEFAULT
     * 三、原子启动模式：ATOMIC
     * 四、懒启动模式：LAZY
     * 五、不分配启动模式：UNDISPATCHED
     */

    companion object {
        const val TAG = "~~~"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P01Case03Binding.inflate(layoutInflater)
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
     * 1.默认启动模式：DEFAULT
     */
    private fun test01() = runBlocking {
        val job = launch(start = CoroutineStart.DEFAULT) {
            Log.d(TAG, "start")
            delay(5000)
            Log.d(TAG, "done")
        }
        job.cancel()
    }

    /**
     * 2.原子启动模式：ATOMIC
     */
    private fun test02() = runBlocking {
        val job = launch(start = CoroutineStart.ATOMIC) {
            Log.d(TAG, "start")
            delay(5000)
            Log.d(TAG, "done")
        }
        job.cancel()
    }

    /**
     * 3.懒启动模式：LAZY
     */
    private fun test03() = runBlocking {
        val job = launch(start = CoroutineStart.LAZY) {
            Log.d(TAG, "start")
            delay(5000)
            Log.d(TAG, "done")
        }
        job.start()
    }

    /**
     * 4.不分配启动模式：UNDISPATCHED
     */
    private fun test04() {
        GlobalScope.launch(Dispatchers.Main) {
            launch(context = Dispatchers.IO, start = CoroutineStart.UNDISPATCHED) {
                Log.d(TAG, "start ${Thread.currentThread().name}")
                delay(5000)
                Log.d(TAG, "done ${Thread.currentThread().name}")
            }
        }
    }
}
