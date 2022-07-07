package com.ling.dagger2.part04.fragment

import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ScopeFragmentModule
 */
@Module
class ScopeFragmentModule {

    @PerScopeFragment
    @Provides
    fun provideScopeFragmentData(): ScopeFragmentData {
        return ScopeFragmentData()
    }
}
