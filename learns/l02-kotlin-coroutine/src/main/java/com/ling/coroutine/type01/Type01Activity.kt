package com.ling.coroutine.type01

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P01Binding
import com.ling.coroutine.type01.p1.*

/**
 * author : wangchengzhen
 * time   : 2022/7/1
 * desc   : Part01: Kotlin 协程 - 基础
 */
class Type01Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
        binding.btnTest2.setOnClickListener(this)
        binding.btnTest3.setOnClickListener(this)
        binding.btnTest4.setOnClickListener(this)
        binding.btnTest5.setOnClickListener(this)
        binding.btnTest6.setOnClickListener(this)
        binding.btnTest7.setOnClickListener(this)
        binding.btnTest8.setOnClickListener(this)
        binding.btnTest9.setOnClickListener(this)
        binding.btnTest10.setOnClickListener(this)
        binding.btnTest11.setOnClickListener(this)
        binding.btnTest12.setOnClickListener(this)
        binding.btnTest13.setOnClickListener(this)
        binding.btnTest14.setOnClickListener(this)
        binding.btnTest15.setOnClickListener(this)
        binding.btnTest16.setOnClickListener(this)
        binding.btnTest17.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> {
                startActivity(Intent(this, Case01Activity::class.java))
            }
            R.id.btn_test2 -> {
                startActivity(Intent(this, Case02Activity::class.java))
            }
            R.id.btn_test3 -> {
                startActivity(Intent(this, Case03Activity::class.java))
            }
            R.id.btn_test4 -> {
                startActivity(Intent(this, Case04Activity::class.java))
            }
            R.id.btn_test5 -> {
                startActivity(Intent(this, Case05Activity::class.java))
            }
            R.id.btn_test6 -> {
                startActivity(Intent(this, Case06Activity::class.java))
            }
            R.id.btn_test7 -> {
                startActivity(Intent(this, Case07Activity::class.java))
            }
            R.id.btn_test8 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p2.Case01Activity::class.java))
            }
            R.id.btn_test9 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p2.Case02Activity::class.java))
            }
            R.id.btn_test10 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p2.Case03Activity::class.java))
            }
            R.id.btn_test11 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p2.Case04Activity::class.java))
            }
            R.id.btn_test12 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p3.Case01Activity::class.java))
            }
            R.id.btn_test13 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p3.Case02Activity::class.java))
            }
            R.id.btn_test14 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p3.Case03Activity::class.java))
            }
            R.id.btn_test15 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p3.Case04Activity::class.java))
            }
            R.id.btn_test16 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p3.Case05Activity::class.java))
            }
            R.id.btn_test17 -> {
                startActivity(Intent(this, com.ling.coroutine.type01.p3.Case06Activity::class.java))
            }
        }
    }
}
