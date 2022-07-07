package com.ling.dagger2.part05.activity.m2

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : Activity2Module
 */
@Module(subcomponents = [DemoSubcomponent::class])
abstract class Activity2Module {

    @Binds
    @IntoMap
    @ClassKey(Demo2Activity::class)
    abstract fun bindDemoActivity(factory: DemoSubcomponent.Factory): AndroidInjector.Factory<*>
}
