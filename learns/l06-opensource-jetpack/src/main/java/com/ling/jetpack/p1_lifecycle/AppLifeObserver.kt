package com.ling.jetpack.p1_lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * author : wangchengzhen
 * time   : 2022/7/7
 * desc   : 监听应用前后台切换
 */
class AppLifeObserver : LifecycleObserver {

    companion object {
        const val TAG = "AppLifecycle"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e(TAG, "onCreate: 应用创建成功")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onForeground() {
        Log.e(TAG, "onForeground: 应用进入前台")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onBackground() {
        Log.e(TAG, "onBackground: 应用进入后台")
    }
}
