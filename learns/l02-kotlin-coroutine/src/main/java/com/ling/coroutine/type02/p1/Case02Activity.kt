package com.ling.coroutine.type02.p1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ling.coroutine.R
import com.ling.coroutine.databinding.ActivityCase02Binding
import kotlinx.coroutines.launch
import kotlin.coroutines.*

/**
 * author : wangchengzhen
 * time   : 2022/6/12
 * desc   : 协程的基础设施层和业务框架层
 */
class Case02Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCase02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCase02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCoroutineBase.setOnClickListener(this)
        binding.btnCoroutineBusiness.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_coroutine_base -> coroutineBase()
            R.id.btn_coroutine_business -> coroutineBusiness()
        }
    }

    /**
     * 基础设施层
     */
    private fun coroutineBase() {
        val continuation = suspend {
            5
        }.createCoroutine(object : Continuation<Int> {
            override val context: CoroutineContext
                get() = EmptyCoroutineContext

            override fun resumeWith(result: Result<Int>) {
                println("Coroutine end: $result")
            }
        })
        continuation.resume(Unit)
    }

    /**
     * 业务框架层
     */
    private fun coroutineBusiness() {
        lifecycleScope.launch {
            val result = 5
            println("Coroutine end: $result")
        }
    }
}
