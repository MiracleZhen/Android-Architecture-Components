package com.ling.dagger2.part05.app

import com.ling.dagger2.part05.activity.m1.Activity1Module
import com.ling.dagger2.part05.activity.m2.Activity2Module
import com.ling.dagger2.part05.fragment.FragmentModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : AppComponent
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class,
    Activity1Module::class, Activity2Module::class, FragmentModule::class])
interface AppComponent {

    fun inject(app: App)
}
