package com.ling.mvp.ui.feed.blog

import com.ling.mvp.ui.feed.blog.view.BlogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BlogFragmentProvider
 */
@Module
abstract class BlogFragmentProvider {

    @ContributesAndroidInjector(modules = [BlogFragmentModule::class])
    internal abstract fun provideBlogFragmentFactory(): BlogFragment
}
