package com.ling.jetpack.p1_lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : 全局管理 Activity - 监听到所有的 Activity 的所有生命周期
 */
class ActivityLifeCallback : Application.ActivityLifecycleCallbacks {

    companion object {
        const val TAG = "ActivityLifecycle"
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.e(TAG, "onActivityCreated: ${activity.javaClass.simpleName}")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.e(TAG, "onActivityStarted: ${activity.javaClass.simpleName}")
    }

    override fun onActivityResumed(activity: Activity) {
        Log.e(TAG, "onActivityResumed: ${activity.javaClass.simpleName}")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.e(TAG, "onActivityPaused: ${activity.javaClass.simpleName}")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.e(TAG, "onActivityStopped: ${activity.javaClass.simpleName}")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.e(TAG, "onActivitySaveInstanceState: ${activity.javaClass.simpleName}")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.e(TAG, "onActivityDestroyed: ${activity.javaClass.simpleName}")
    }
}
