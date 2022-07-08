package com.ling.jetpack.p1_lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * author : wangchengzhen
 * time   : 2022/7/7
 * desc   : LifecycleObserver接口
 * 1.实现LifecycleObserver 接口，使用 @OnLifecycleEvent注解在方法上，注解值表示该方法对应生命周期的哪个函数
 */
class TestLifecycle : LifecycleObserver {

    companion object {
        const val TAG = "TestLifecycle"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onChange() {
        Log.e(TAG, "onChange")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e(TAG, "onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.e(TAG, "onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.e(TAG, "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.e(TAG, "onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.e(TAG, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.e(TAG, "onDestroy")
    }
}
