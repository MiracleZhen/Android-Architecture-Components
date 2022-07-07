package com.ling.dagger2.part05.app

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : App
 * https://github.com/MindorksOpenSource/android-dagger2-example
 * https://github.com/MindorksOpenSource/Dagger-Dynamic-Feature-Module
 * https://github.com/MindorksOpenSource/Dagger-Multi-Module-Android
 */
class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}
