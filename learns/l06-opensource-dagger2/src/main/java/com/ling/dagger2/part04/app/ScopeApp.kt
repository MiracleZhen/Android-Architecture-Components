package com.ling.dagger2.part04.app

import android.app.Application

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : Dagger2 知识梳理(4) @Scope 注解的使用
 * blog   : https://juejin.cn/post/6844903524065640456
 */
class ScopeApp : Application() {

    private lateinit var scopeAppComponent: ScopeAppComponent

    override fun onCreate() {
        super.onCreate()
        scopeAppComponent = DaggerScopeAppComponent.builder()
            .scopeAppModule(ScopeAppModule())
            .build()
    }

    fun getAppComponent(): ScopeAppComponent {
        return scopeAppComponent
    }
}
