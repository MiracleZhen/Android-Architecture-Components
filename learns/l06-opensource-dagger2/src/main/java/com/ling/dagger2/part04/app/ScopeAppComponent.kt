package com.ling.dagger2.part04.app

import dagger.Component
import javax.inject.Singleton

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ScopeAppComponent - 每个进程只有一个实例。
 */
@Singleton
@Component(modules = [ScopeAppModule::class])
interface ScopeAppComponent {

    /**
     * 如果它被其它的Component依赖，那么需要声明getXXX方法。
     */
    fun getScopeAppData(): ScopeAppData
}
