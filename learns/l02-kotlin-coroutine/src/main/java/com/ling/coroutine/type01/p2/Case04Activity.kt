package com.ling.coroutine.type01.p2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P02Case04Binding
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * author : wangchengzhen
 * time   : 2022/7/3
 * desc   : Kotlin 协程 （十一） ——— Flow 末端操作符、组合/展平操作符
 * blog   : https://juejin.cn/post/7089085724661809160
 */
class Case04Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、末端操作符
     * 二、组合/展平操作符
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P02Case04Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
        binding.btnTest4.setOnClickListener(this)
        binding.btnTest5.setOnClickListener(this)
        binding.btnTest6.setOnClickListener(this)
        binding.btnTest7.setOnClickListener(this)
        binding.btnTest8.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> test01()
            R.id.btn_test2 -> test02()
            R.id.btn_test3 -> test03()
            R.id.btn_test4 -> test04()
            R.id.btn_test5 -> test05()
            R.id.btn_test6 -> test06()
            R.id.btn_test7 -> test07()
            R.id.btn_test8 -> test08()
        }
    }

    /**
     * collect()
     */
    private fun test01() = runBlocking {
        flowOf(1, 2, 3).collect {
            println("Collect $it")
        }
    }

    /**
     * toList()、toSet()
     */
    private fun test02() = runBlocking {
        val list = flowOf(1, 2, 3).toList()
        println(list.joinToString())
        val set = flowOf(1, 2, 3).toSet()
        println(set.joinToString())
    }

    /**
     * first()、single()
     */
    private fun test03() = runBlocking {
        val first = flowOf(1, 2, 3).first()
        println(first)
        val single = flowOf(1).single()
        println(single)
    }

    /**
     * reduce()、fold()
     */
    private fun test04() = runBlocking {
        val reduce = flowOf(1, 2, 3).reduce { accumulator, value ->
            println("accumulator: $accumulator, value: $value")
            accumulator + value
        }
        println("reduce: $reduce")

        val fold = flowOf(1, 2, 3).fold(0) { accumulator, value ->
            println("accumulator: $accumulator, value: $value")
            accumulator + value
        }
        println("fold: $fold")

        val fold2 = flowOf(1, 2, 3).fold<Int, String>("initial") { accumulator, value ->
            println("accumulator: $accumulator, value: $value")
            "$accumulator $value"
        }
        println(fold2)
    }

    /**
     * zip()
     */
    private fun test05() = runBlocking {
        flowOf("a", "b", "c").zip(flowOf(1, 2, 3)) { a, b ->
            a + b
        }.collect {
            println(it)
        }
    }

    /**
     * flatMapConcat()
     */
    private fun test06() = runBlocking {
        flowOf("初中", "高中").flatMapConcat {
            flowOf(it + "一年级", it + "二年级", it + "三年级")
        }.collect {
            println(it)
        }

        val startTime = System.currentTimeMillis()
        flow {
            repeat(3) {
                delay(1000)
                println("emit: $it, cost time: ${System.currentTimeMillis() - startTime}ms, thread: ${Thread.currentThread().name}")
                emit(it)
            }
        }.flatMapConcat {
            flow {
                delay(5000)
                emit("flatMap $it, cost time: ${System.currentTimeMillis() - startTime}ms, thread: ${Thread.currentThread().name}")
            }
        }.collect {
            println("Collect: $it, cost time: ${System.currentTimeMillis() - startTime}ms, thread: ${Thread.currentThread().name}")
        }
    }

    /**
     * flatMapMerge()
     */
    private fun test07() = runBlocking {
        val startTime = System.currentTimeMillis()
        flow {
            repeat(3) {
                delay(1000)
                println("emit: $it, cost time: ${System.currentTimeMillis() - startTime}ms, thread: ${Thread.currentThread().name}")
                emit(it)
            }
        }.flatMapMerge {
            flow {
                delay(5000)
                emit("flatMap $it, cost time: ${System.currentTimeMillis() - startTime}ms, thread: ${Thread.currentThread().name}")
            }
        }.collect {
            println("Collect: $it, cost time: ${System.currentTimeMillis() - startTime}ms, thread: ${Thread.currentThread().name}")
        }
    }

    /**
     * flatMapLatest()
     */
    private fun test08() = runBlocking {
        val startTime = System.currentTimeMillis()
        flow {
            repeat(3) {
                delay(1000)
                println("emit: $it, cost time: ${System.currentTimeMillis() - startTime}ms, thread: ${Thread.currentThread().name}")
                emit(it)
            }
        }.flatMapLatest {
            flow {
                try {
                    println("Start flatMap $it")
                    delay(5000)
                    println("emit flatMap $it")
                    emit("flatMap $it, cost time: ${System.currentTimeMillis() - startTime}ms, thread: ${Thread.currentThread().name}")
                } catch (e: CancellationException) {
                    println("flatMap $it cancelled")
                }
            }
        }.collect {
            println("Collect: $it, cost time: ${System.currentTimeMillis() - startTime}ms, thread: ${Thread.currentThread().name}")
        }
    }
}
