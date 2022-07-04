package com.ling.coroutine.type01.p2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P02Case03Binding
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * author : wangchengzhen
 * time   : 2022/7/3
 * desc   : Kotlin 协程 （十） ——— Flow 过渡操作符、限长操作符
 * blog   : https://juejin.cn/post/7088707206639517710
 */
class Case03Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、过渡操作符
     * 二、限长操作符
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P02Case03Binding.inflate(layoutInflater)
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
     * 转换：transform()
     */
    private fun test01() = runBlocking {
        flowOf(1, 2, 3).transform {
            emit("transformed $it")
        }.collect {
            println("Collect: $it")
        }
    }

    /**
     * 映射：map()
     */
    private fun test02() = runBlocking {
        flowOf(1, 2, 3).map {
            "mapped $it"
        }.collect {
            println("Collect: $it")
        }
    }

    /**
     * 取前几个值：take()
     */
    private fun test03() = runBlocking {
        flowOf(1, 2, 3).take(1).collect {
            println("Collect: $it")
        }
    }

    /**
     * 取满足条件的值：takeWhile()
     */
    private fun test04() = runBlocking {
        flowOf(1, 2, 3).takeWhile {
            it % 2 == 1
        }.collect {
            println("Collect: $it")
        }
    }

    /**
     * 丢弃前几个值：drop()
     */
    private fun test05() = runBlocking {
        flowOf(1, 2, 3).drop(1).collect {
            println("Collect: $it")
        }
    }

    /**
     * 丢弃满足条件的值 dropWhile()
     */
    private fun test06() = runBlocking {
        flowOf(1, 2, 3).dropWhile {
            it < 2
        }.collect {
            println("Collect: $it")
        }
    }
}
