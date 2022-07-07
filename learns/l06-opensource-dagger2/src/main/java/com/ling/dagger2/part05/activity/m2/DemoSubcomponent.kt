package com.ling.dagger2.part05.activity.m2

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Named

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : DemoSubcomponent
 */
@Subcomponent(modules = [DemoSubcomponent.SubModule::class])
interface DemoSubcomponent : AndroidInjector<Demo2Activity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<Demo2Activity>

    @Module
    class SubModule {

        @Named("name")
        @Provides
        fun provideName(): String {
            return "Marry"
        }
    }
}
