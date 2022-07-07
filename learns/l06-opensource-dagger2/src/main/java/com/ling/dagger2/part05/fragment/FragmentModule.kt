package com.ling.dagger2.part05.fragment

import com.ling.dagger2.part05.activity.m1.Demo1Module
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : FragmentModule
 */
@Module
interface FragmentModule {

    @ContributesAndroidInjector(modules = [DemoModule::class, Demo1Module::class])
    fun contributeDemoFragment(): DemoFragment
}
