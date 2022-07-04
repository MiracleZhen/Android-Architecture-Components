package com.ling.coroutine.type01.p3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P03Case05Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * author : wangchengzhen
 * time   : 2022/7/4
 * desc   : Kotlin 协程 （十六） ——— StateFlow 简介
 * blog   : https://juejin.cn/post/7090930827906793485
 */
class Case05Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、使用 StateFlow 实现 LiveData
     * 二、使用 StateFlow 的 Flow 特性
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P03Case05Binding.inflate(layoutInflater)
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
     * LiveData
     */
    private fun test01() {
        println("init liveData with 0")
        val liveData = MutableLiveData(0)
        liveData.observe(this) {
            println("received: $it")
        }
        lifecycleScope.launchWhenCreated {
            delay(1000)
            println("set liveData.value = 1")
            liveData.value = 1
            delay(1000)
            println("set liveData.value = 2")
            liveData.value = 2
        }
    }

    /**
     * 使用 StateFlow 实现 LiveData
     */
    private fun test02() = runBlocking {
        println("init stateFlow with 0")
        val stateFlow = MutableStateFlow(0)
        val job = launch {
            stateFlow.collect {
                println("received: $it")
            }
        }
        delay(1000)
        println("set stateFlow.value = 1")
        stateFlow.value = 1
        delay(1000)
        println("set stateFlow.value = 2")
        stateFlow.value = 2
        delay(1000)
        job.cancel()
    }

    /**
     * 使用 StateFlow 的 Flow 特性
     */
    private fun test03() = runBlocking {
        println("init stateFlow with 0")
        val stateFlow = MutableStateFlow(0)
        val job = launch {
            stateFlow.map {
                "converted $it"
            }.collect {
                println("received: $it, stateFlow.value = ${stateFlow.value}")
            }
        }
        delay(1000)
        println("set stateFlow.value = 1")
        stateFlow.value = 1
        delay(1000)
        job.cancel()
    }
}
