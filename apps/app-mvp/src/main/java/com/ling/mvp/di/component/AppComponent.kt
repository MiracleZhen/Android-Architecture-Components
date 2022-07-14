package com.ling.mvp.di.component

import android.app.Application
import com.ling.mvp.app.MvpApplication
import com.ling.mvp.di.builder.ActivityBuilder
import com.ling.mvp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : AppComponent
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(application: MvpApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
