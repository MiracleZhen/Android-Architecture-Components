package com.ling.dagger2.part04.activity

import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ScopeActivityModule
 */
@Module
class ScopeActivityModule {

    @PerScopeActivity
    @Provides
    fun provideScopeActivityData(): ScopeActivitySharedData {
        return ScopeActivitySharedData()
    }

    @Provides
    fun provideScopeActivityNormalData(): ScopeActivityNormalData {
        return ScopeActivityNormalData()
    }
}
