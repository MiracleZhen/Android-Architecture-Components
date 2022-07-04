package com.ling.coroutine.type01.p1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P01Case04Binding
import kotlinx.coroutines.*

/**
 * author : wangchengzhen
 * time   : 2022/7/1
 * desc   : Kotlin 协程 （四） ——— Job 对象
 * blog   : https://juejin.cn/post/7086483954856886285
 */
class Case04Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、Job 简介
     * 二、Job 的状态
     * 三、Job 的生命周期
     * 四、Job 的取消
     * 五、判断 Job 的状态
     * 六、取消 Job 时释放资源
     * 七、Job 超时处理
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P01Case04Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> test01()
            R.id.btn_test2 -> test02()
            R.id.btn_test3 -> test03()
        }
    }

    /**
     * Job 的取消
     */
    private fun test01() = runBlocking {
        val job = launch(start = CoroutineStart.ATOMIC) {
            try {
                println("start")
                delay(500)
                println("done")
            } catch (e: CancellationException) {
                e.printStackTrace()
            }
        }
        job.cancel()
    }

    /**
     * 判断 Job 的状态
     */
    private fun test02() = runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5 && isActive) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("I'm sleeping $i")
                    i++
                    nextPrintTime += 500
                }
            }
        }
        delay(1200)
        println("Time to finish")
        job.cancelAndJoin()
        println("Done")
    }

    /**
     * Job 超时处理
     */
    private fun test03() {
        runBlocking {
            try {
                withTimeout(500) {
                    launch {
                        delay(1000)
                    }
                }
            } catch (e: TimeoutCancellationException) {
                e.printStackTrace()
            }
        }

        runBlocking {
            val result = withTimeoutOrNull(500) {
                launch {
                    delay(1000)
                }
            }
            println("result: $result")
        }
    }
}
