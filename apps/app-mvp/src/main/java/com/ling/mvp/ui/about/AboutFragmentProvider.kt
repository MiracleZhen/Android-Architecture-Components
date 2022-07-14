package com.ling.mvp.ui.about

import com.ling.mvp.ui.about.view.AboutFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : AboutFragmentProvider
 */
@Module
abstract class AboutFragmentProvider {

    @ContributesAndroidInjector
    internal abstract fun provideAboutFragment(): AboutFragment
}
