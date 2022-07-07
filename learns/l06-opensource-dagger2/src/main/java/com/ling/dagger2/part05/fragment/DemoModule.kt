package com.ling.dagger2.part05.fragment

import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : DemoModule
 */
@Module
class DemoModule {

    @Named("fragmentData")
    @Provides
    fun provideName(): String {
        return "fragment data"
    }
}
