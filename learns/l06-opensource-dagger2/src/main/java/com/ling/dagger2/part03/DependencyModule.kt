package com.ling.dagger2.part03

import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : DependencyModule
 */
@Module
class DependencyModule {

    @Provides
    fun provideDependencySource(): DependencySource {
        return DependencySource()
    }
}
