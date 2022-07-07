package com.ling.dagger2.part01

import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : 创建一个RemoteSourceModule类，用于提供RemoteSource对象
 */
@Module
class RemoteSourceModule {

    @Provides
    fun provideRemoteSource(): RemoteSource {
        return RemoteSource()
    }
}
