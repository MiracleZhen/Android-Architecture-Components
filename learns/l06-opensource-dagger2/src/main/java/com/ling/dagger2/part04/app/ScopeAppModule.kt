package com.ling.dagger2.part04.app

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ScopeAppModule
 */
@Module
class ScopeAppModule {

    @Singleton
    @Provides
    fun provideScopeAppData(): ScopeAppData {
        return ScopeAppData()
    }
}
