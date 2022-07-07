package com.ling.dagger2.part05.activity.m1

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ActivityModule
 */
@Module
interface Activity1Module {

    @ContributesAndroidInjector(modules = [Demo1Module::class])
    fun contributeDemo1Activity(): Demo1Activity
}
