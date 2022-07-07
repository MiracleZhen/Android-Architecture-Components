package com.ling.dagger2.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : AppModule
 */
@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Named("appName")
    @Provides
    fun provideName(): String {
        return "app name"
    }
}
