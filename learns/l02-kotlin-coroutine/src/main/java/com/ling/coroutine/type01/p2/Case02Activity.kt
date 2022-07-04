package com.ling.coroutine.type01.p2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P02Case02Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * author : wangchengzhen
 * time   : 2022/7/3
 * desc   : Kotlin 协程 （九） ——— Flow 背压
 * blog   : https://juejin.cn/post/7088338829316210702
 */
class Case02Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、背压
     * 二、解决背压方式一：buffer()
     * 三、解决背压方式二：conflate()
     * 四、解决背压方式三：collectLatest()
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P02Case02Binding.inflate(layoutInflater)
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
     * 背压
     */
    private fun test01() = runBlocking {
        val time = measureTimeMillis {
            flow {
                (1..5).forEach {
                    delay(200)
                    println("emit: $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
                    emit(it)
                }
            }.collect {
                // 消费效率较低
                delay(500)
                println("Collect $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
            }
        }
        println("time: $time")
    }

    /**
     * 解决背压方式一：buffer()
     */
    private fun test02() = runBlocking {
        val time = measureTimeMillis {
            flow {
                (1..5).forEach {
                    delay(200)
                    println("emit: $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
                    emit(it)
                }
            }.buffer().collect {
                // 消费效率较低
                delay(500)
                println("Collect $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
            }
        }
        println("time: $time")
    }

    /**
     * 解决背压方式二：conflate()
     */
    private fun test03() = runBlocking {
        val time = measureTimeMillis {
            flow {
                (1..5).forEach {
                    delay(200)
                    println("emit: $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
                    emit(it)
                }
            }.conflate().collect {
                // 消费效率较低
                println("Collect $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
                delay(500)
                println("Collect $it done, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
            }
        }
        println("time: $time")
    }

    /**
     * 解决背压方式三：collectLatest()
     */
    private fun test04() = runBlocking {
        val time = measureTimeMillis {
            flow {
                (1..5).forEach {
                    delay(200)
                    println("emit: $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
                    emit(it)
                }
            }.collectLatest {
                // 消费效率较低
                println("Collect $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
                delay(500)
                println("Collect $it done, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
            }
        }
        println("time: $time")
    }
}
