package com.ling.mvp.ui.rate

import com.ling.mvp.ui.rate.view.RateUsDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : RateUsDialogFragmentProvider
 */
@Module
abstract class RateUsDialogFragmentProvider {

    @ContributesAndroidInjector(modules = [RateUsFragmentModule::class])
    internal abstract fun provideRateUsFragment(): RateUsDialog
}
