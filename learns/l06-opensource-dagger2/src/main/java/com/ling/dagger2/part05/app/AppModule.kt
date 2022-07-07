package com.ling.dagger2.part05.app

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : AppModule
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideAppData(): AppData {
        return AppData()
    }
}
