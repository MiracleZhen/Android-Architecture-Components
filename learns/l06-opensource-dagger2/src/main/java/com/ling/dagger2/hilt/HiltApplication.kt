package com.ling.dagger2.hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : HiltApplication
 * https://github.com/QiChaoLau/HiltDemo
 * https://github.com/MindorksOpenSource/Dagger-Hilt-Tutorial
 * https://github.com/ahmedeltaher/MVVM-Kotlin-Android-Architecture (MVVM + Kotlin + Retrofit2 + Hilt + Coroutines + Kotlin Flow + mockK + Espresso + Junit5)
 */
@HiltAndroidApp
class HiltApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
