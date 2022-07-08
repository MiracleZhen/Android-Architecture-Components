package com.ling.jetpack.app

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * author : wangchengzhen
 * time   : 2022/7/7
 * desc   : Android-Jetpack-ProcessLifecycleOwner监听App的生命周期
 * blog   : https://www.jianshu.com/p/db86b09d9cb3
 */
class AppObserver : LifecycleObserver {

    companion object {
        const val TAG = "~ app lifecycle ~"
    }

    /**
     * 在App的整个生命周期中只会被调用一次
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e(TAG, ">>>>>>> onCreate")
    }

    /**
     * 在App在前台出现时被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.e(TAG, ">>>>>>> onStart")
    }

    /**
     * 在App在前台出现时被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.e(TAG, ">>>>>>> onResume")
    }

    /**
     * 在App退出到后台时被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.e(TAG, ">>>>>>> onPause")
    }

    /**
     * 在App退出到后台时被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.e(TAG, ">>>>>>> onStop")
    }

    /**
     * 理论上是不会触发这个事件的，因为系统不会分发，在项目当中可以不写这个事件
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.e(TAG, ">>>>>>> onDestroy")
    }
}
