package com.ling.mvp.di.builder

import com.ling.mvp.ui.about.AboutFragmentProvider
import com.ling.mvp.ui.feed.blog.BlogFragmentProvider
import com.ling.mvp.ui.feed.opensource.OpenSourceFragmentProvider
import com.ling.mvp.ui.feed.opensource.view.OpenSourceFragment
import com.ling.mvp.ui.feed.view.FeedActivity
import com.ling.mvp.ui.login.LoginActivityModule
import com.ling.mvp.ui.login.view.LoginActivity
import com.ling.mvp.ui.main.MainActivityModule
import com.ling.mvp.ui.main.view.MainActivity
import com.ling.mvp.ui.rate.RateUsDialogFragmentProvider
import com.ling.mvp.ui.splash.SplashActivityModule
import com.ling.mvp.ui.splash.view.SplashMvpActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : ActivityBuilder
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashMvpActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [MainActivityModule::class, AboutFragmentProvider::class, RateUsDialogFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [BlogFragmentProvider::class, OpenSourceFragmentProvider::class])
    abstract fun bindFeedActivity(): FeedActivity
}
