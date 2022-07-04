package com.ling.coroutine.type01.p1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityType01P01Case02Binding
import kotlinx.coroutines.*

/**
 * author : wangchengzhen
 * time   : 2022/6/30
 * desc   : Kotlin 协程 （二） ——— 结构化并发
 * blog   : https://juejin.cn/post/7085742148414341150
 */
class Case02Activity : AppCompatActivity(), View.OnClickListener {

    /**
     * 一、结构化并发的优点
     * 二、作用域：CoroutineScope
     * 三、调度器：Dispatchers
     */

    companion object {
        const val TAG = "~~~"
    }

    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityType01P01Case02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_test1 -> test01()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }

    private fun test01() {
        mainScope.launch {
            // do something
            delay(1000)
            Log.d(TAG, "do something")
        }
    }
}
