package com.ling.coroutine.type01.p1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P01Case06Binding
import kotlinx.coroutines.*
import java.io.IOException
import java.lang.IllegalArgumentException

/**
 * author : wangchengzhen
 * time   : 2022/7/1
 * desc   : Kotlin 协程 （六） ——— 协程异常处理：CoroutineExceptionHandler
 * blog   : https://juejin.cn/post/7087222504170717192
 */
class Case06Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、协程异常简介
     * 二、异常的传播特性
     * 三、异常的捕获
     * 四、Android 中，Kotiln 协程全局异常处理器
     * 五、异常聚合
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P01Case06Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
        binding.btnTest4.setOnClickListener(this)
        binding.btnTest5.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> test01()
            R.id.btn_test2 -> test02()
            R.id.btn_test3 -> test03()
            R.id.btn_test4 -> test04()
            R.id.btn_test5 -> test05()
        }
    }

    /**
     * 协程中的异常分为两种：一种是在协程内部直接抛出异常，另一种则是在协程启动处抛出异常。
     * 1.使用 GlobalScope.launch 创建的协程发生异常时，只能在协程内部捕捉到。
     * 2.使用 GlobalScope.async 创建的协程发生异常时，不仅可以在内部捕捉到，还可以在 await 处捕捉到。
     */
    private fun test01() = runBlocking<Unit> {
        val job = GlobalScope.launch {
            try {
                throw Exception()
            } catch (e: Exception) {
                println("catch in coroutine")
            }
        }
        job.join()

        val deferred = GlobalScope.async {
            throw Exception()
        }
        try {
            deferred.await()
        } catch (e: Exception) {
            println("catch in await")
        }
    }

    /**
     * 根协程和子协程的异常传播规则如下：
     * 1.根协程的 launch/actor 函数创建的协程会自动传播异常，async/produce 函数创建的协程会向用户暴露异常。
     * 2.非根协程中，产生的异常总是会自动传播。
     */
    private fun test02() = runBlocking {
        // 根协程 launch 创建的协程，第一时间抛出异常
        val globalLaunchJob = GlobalScope.launch {
            try {
                throw Exception()
            } catch (e: Exception) {
                println("catch exception in GlobalScope.launch")
            }
        }

        // 根协程 async 创建的协程，await 时才抛出异常
        val globalAsyncJob = GlobalScope.async {
            throw Exception()
        }
        try {
            globalAsyncJob.await()
        } catch (e: Exception) {
            println("catch exception when globalAsyncJob.await()")
        }

        // 非根协程 launch 创建的协程，第一时间抛出异常
        val launchJob = launch {
            try {
                throw Exception()
            } catch (e: Exception) {
                println("catch exception in launch")
            }
        }

        // 非根协程 async 创建的协程，第一时间抛出异常
        val asyncJob = async {
            try {
                throw Exception()
            } catch (e: Exception) {
                println("catch exception in async")
            }
        }
        asyncJob.await()
    }

    /**
     * 异常的传播特性 - 当一个协程自己抛出异常时，它的所有子协程都会被取消。
     */
    private fun test03() = runBlocking<Unit> {
        supervisorScope {
            launch {
                try {
                    println("The child is sleeping")
                    delay(Long.MAX_VALUE)
                } finally {
                    println("The child is cancelled")
                }
            }
            yield()
            println("Throwing an exception from the scope")
            throw Exception()
        }
    }

    /**
     * 异常的捕获 - 协程上下文中的 CoroutineExceptionHandler 是用来捕获协程未处理异常的
     */
    private fun test04() {
        runBlocking {
            val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
                println("Caught $throwable")
            }
            val scope = CoroutineScope(Job())
            val job = scope.launch(handler) {
                throw Exception()
            }
            job.join()
        }

        runBlocking {
            val handler = CoroutineExceptionHandler { _, throwable ->
                println("Caught $throwable")
            }
            val scope = CoroutineScope(Job())
            val job = scope.launch {
                launch(handler) {
                    throw Exception()
                }
            }
            job.join()
        }
    }

    /**
     * 异常聚合
     */
    private fun test05() = runBlocking {
        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Caught $throwable, suppressed: ${throwable.suppressed.contentToString()}")
        }
        val job = GlobalScope.launch(handler) {
            launch {
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    throw IllegalArgumentException("I'm IllegalArgument")
                }
            }
            launch {
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    throw ArithmeticException("I'm Arithmetic")
                }
            }
            launch {
                throw IOException("I'm IO")
            }
        }
    }
}
