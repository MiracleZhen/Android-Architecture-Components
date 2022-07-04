package com.ling.coroutine.type01.p1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P01Case01Binding
import kotlinx.coroutines.*
import kotlin.coroutines.*

/**
 * author : wangchengzhen
 * time   : 2022/6/29
 * desc   : Kotlin 协程（一） ——— 简介
 * blog   : https://juejin.cn/post/7085352414068342798
 */
class Case01Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、进程、线程与协程
     * 二、协程的优势
     * 三、协程的基础设施与上层框架
     * 四、挂起函数
     * 五、开启协程：launch VS async
     * 六、阻塞协程：join VS await
     */

    companion object {
        const val TAG = "~~~"
    }

    private lateinit var binding: ActivityType01P01Case01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityType01P01Case01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
        binding.btnTest4.setOnClickListener(this)
        binding.btnTest5.setOnClickListener(this)
        binding.btnTest6.setOnClickListener(this)
    }

    @DelicateCoroutinesApi
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> test01()
            R.id.btn_test2 -> test02()
            R.id.btn_test3 -> test03()
            R.id.btn_test4 -> test04()
            R.id.btn_test5 -> test05()
            R.id.btn_test6 -> test06()
        }
    }

    /**
     * 3.1 用协程的基础设施实现协程
     */
    private fun test01() {
        // 创建协程
        val continuation = suspend {
            1
        }.createCoroutine(object : Continuation<Int> {

            override val context: CoroutineContext
                get() = EmptyCoroutineContext

            override fun resumeWith(result: Result<Int>) {
                Log.d(TAG, "result: $result")
            }
        })
        // 启动协程
        continuation.resume(Unit)
    }

    /**
     * 3.2 用上层框架开启一个协程
     */
    @DelicateCoroutinesApi
    private fun test02() {
        GlobalScope.launch {
            println("coroutine scope")
        }
        // 等待一秒钟保证协程运行完毕
        Thread.sleep(1000)
    }

    /**
     * 4.1 挂起函数
     */
    @DelicateCoroutinesApi
    private fun test03() {
        GlobalScope.launch {
            delaySomeTime()
            println("coroutine scope")
        }
        println("suspend function")
    }

    /**
     * 挂起函数
     */
    private suspend fun delaySomeTime() {
        delay(1000)
    }

    /**
     * 5.1 开启协程：launch VS async
     */
    @DelicateCoroutinesApi
    private fun test04() {
        val job1 = GlobalScope.launch {
            println("launch")
        }

        val job2 = GlobalScope.async {
            println("async")
        }
    }

    /**
     * 6.1 阻塞协程：join VS await
     * 如果 async 开启协程后，马上调用 await()，这种写法会让两个协程串行执行，效率低
     */
    private fun test05() = runBlocking {
        val start = System.currentTimeMillis()
        val result1 = async {
            delay(1000)
            1 + 1
        }.await()
        val result2 = async {
            delay(1000)
            1 + 1
        }.await()
        Log.d(TAG, "result = ${result1 + result2}")
        // await 会阻塞协程，所以这种写法会导致两个协程串行执行，耗时 2 秒左右
        Log.d(TAG, "cost: ${System.currentTimeMillis() - start}")
    }

    /**
     * 6.2 阻塞协程：join VS await
     * 先用 async 开启两个协程，再统一调用 await()，让两个协程并行执行，效率更高
     */
    private fun test06() = runBlocking {
        val start = System.currentTimeMillis()
        val deferred1 = async {
            delay(1000)
            1 + 1
        }
        val deferred2 = async {
            delay(1000)
            1 + 1
        }
        val result1 = deferred1.await()
        val result2 = deferred2.await()
        Log.d(TAG, "result = ${result1 + result2}")
        // 统一调用 await 方法，让两个协程并行执行，耗时 1 秒左右，效率高
        Log.d(TAG, "cost: ${System.currentTimeMillis() - start}")
    }
}
