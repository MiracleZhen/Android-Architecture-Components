package com.ling.jetpack.app

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.ling.jetpack.p1_lifecycle.ActivityLifeCallback
import com.ling.jetpack.p1_lifecycle.AppLifeObserver

/**
 * author : wangchengzhen
 * time   : 2022/7/7
 * desc   : JetpackApplication
 */
class JetpackApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ActivityLifeCallback())
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppObserver())
        ProcessLifecycleOwner.get().lifecycle.addObserver(AppLifeObserver())
    }
}
