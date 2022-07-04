package com.ling.coroutine.type01.p3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P03Case03Binding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.sync.withPermit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock

/**
 * author : wangchengzhen
 * time   : 2022/7/4
 * desc   : Kotlin 协程 （十四） ——— 并发安全
 * blog   : https://juejin.cn/post/7090180827765538829
 */
class Case03Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、并发不安全
     * 二、多线程中的并发安全工具
     * 三、协程中的并发安全工具
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P03Case03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
        binding.btnTest4.setOnClickListener(this)
        binding.btnTest5.setOnClickListener(this)
        binding.btnTest6.setOnClickListener(this)
    }

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
     * 并发不安全
     */
    private fun test01() = runBlocking {
        var count = 0
        val job1 = GlobalScope.launch {
            repeat(100000) {
                count++
            }
        }
        val job2 = GlobalScope.launch {
            repeat(100000) {
                count--
            }
        }
        job1.join()
        job2.join()
        println("count: $count")
    }

    /**
     * 多线程中的并发安全工具 - Lock
     */
    private fun test02() = runBlocking {
        var count = 0
        val lock = ReentrantLock()
        val job1 = GlobalScope.launch {
            repeat(100000) {
                lock.lock()
                count++
                lock.unlock()
            }
        }
        val job2 = GlobalScope.launch {
            repeat(100000) {
                lock.lock()
                count--
                lock.unlock()
            }
        }
        job1.join()
        job2.join()
        println("count: $count")
    }

    /**
     * 多线程中的并发安全工具 - synchronized
     */
    private fun test03() = runBlocking {
        var count = 0
        val lock = Any()
        val job1 = GlobalScope.launch {
            repeat(100000) {
                synchronized(lock) {
                    count++
                }
            }
        }
        val job2 = GlobalScope.launch {
            repeat(100000) {
                synchronized(lock) {
                    count--
                }
            }
        }
        job1.join()
        job2.join()
        println("count: $count")
    }

    /**
     * 多线程中的并发安全工具 - CAS
     */
    private fun test04() = runBlocking {
        val count = AtomicInteger(0)
        val job1 = GlobalScope.launch {
            repeat(100000) {
                count.incrementAndGet()
            }
        }
        val job2 = GlobalScope.launch {
            repeat(100000) {
                count.decrementAndGet()
            }
        }
        job1.join()
        job2.join()
        println("count: $count")
    }

    /**
     * 协程中的并发安全工具 - Mutex
     */
    private fun test05() = runBlocking {
        var count = 0
        val mutex = Mutex()
        val job1 = GlobalScope.launch {
            repeat(100000) {
                mutex.withLock {
                    count++
                }
            }
        }
        val job2 = GlobalScope.launch {
            repeat(100000) {
                mutex.withLock {
                    count--
                }
            }
        }
        job1.join()
        job2.join()
        println("count: $count")
    }

    /**
     * 协程中的并发安全工具 - Semaphore
     */
    private fun test06() = runBlocking {
        var count = 0
        val semaphore = Semaphore(1)
        val job1 = GlobalScope.launch {
            repeat(100000) {
                semaphore.withPermit {
                    count++
                }
            }
        }
        val job2 = GlobalScope.launch {
            repeat(100000) {
                semaphore.withPermit {
                    count--
                }
            }
        }
        job1.join()
        job2.join()
        println("count: $count")
    }
}
