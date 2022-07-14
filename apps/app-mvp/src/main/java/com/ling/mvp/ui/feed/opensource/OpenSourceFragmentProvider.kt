package com.ling.mvp.ui.feed.opensource

import com.ling.mvp.ui.feed.opensource.view.OpenSourceFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : OpenSourceFragmentProvider
 */
@Module
internal abstract class OpenSourceFragmentProvider {

    @ContributesAndroidInjector(modules = [(OpenSourceFragmentModule::class)])
    internal abstract fun provideBlogFragmentFactory(): OpenSourceFragment
}
