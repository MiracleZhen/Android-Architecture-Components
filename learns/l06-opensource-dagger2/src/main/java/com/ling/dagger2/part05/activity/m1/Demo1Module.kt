package com.ling.dagger2.part05.activity.m1

import com.ling.dagger2.part05.activity.ActivityData
import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ActivityDemo1Module
 */
@Module
class Demo1Module {

    @Provides
    fun provideActivityData(): ActivityData {
        return ActivityData()
    }
}
