package com.ling.base

import android.app.Application

/**
 *  author : wangchengzhen
 *  github : https://github.com/chengzhen-wang/Android-Architecture-Components
 *  time   : 2022/5/17
 *  desc   : Application 基类
 */
abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initSdk(this)
    }

    /**
     * 初始化一些第三方框架
     */
    abstract fun initSdk(application: Application)
}
