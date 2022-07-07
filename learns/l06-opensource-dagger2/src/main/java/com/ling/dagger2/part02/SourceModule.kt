package com.ling.dagger2.part02

import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : 创建工厂类
 */
@Module
class SourceModule {

    @Local
    // @Named("Local")
    @Provides
    fun provideLocalSource(): Source {
        return LocalSource()
    }

    @Remote
    // @Named("Remote")
    @Provides
    fun provideRemoteSource(): Source {
        return RemoteSource()
    }
}
