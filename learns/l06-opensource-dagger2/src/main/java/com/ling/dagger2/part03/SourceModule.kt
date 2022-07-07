package com.ling.dagger2.part03

import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : SourceModule
 */
@Module
class SourceModule {

    @Provides
    fun provideLocalSource(): LocalSource {
        return LocalSource()
    }
}
