package com.ling.jetpack.p1_lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ling.jetpack.R
import com.ling.jetpack.databinding.ActivityLifecycleBinding

/**
 * author : wangchengzhen
 * time   : 2022/7/7
 * desc   : Lifecycle是一个生命周期感知组件，一般用来响应Activity、Fragment等组件的生命周期变化，并将变化通知到已注册的观察者。
 * 有助于更好地组织代码，让代码逻辑符合生命周期规范，减少内存泄漏，增强稳定性。
 * blog   : https://blog.csdn.net/dfvbrtdhy/article/details/118481009
 */
class LifecycleActivity : AppCompatActivity() {

    companion object {
        const val TAG = "LifecycleActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate start")
        val binding = ActivityLifecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLifecycleCustom.setOnClickListener {
            startActivity(Intent(this, LifecycleCustomActivity::class.java))
        }

        // 2.将LifecycleObserver添加到Lifecycle的观察者列表
        lifecycle.addObserver(TestLifecycle())
        Log.e(TAG, "onCreate end")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart")
    }
}
