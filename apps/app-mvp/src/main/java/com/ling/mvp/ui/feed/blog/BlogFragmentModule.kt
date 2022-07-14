package com.ling.mvp.ui.feed.blog

import androidx.recyclerview.widget.LinearLayoutManager
import com.ling.mvp.ui.feed.blog.interactor.BlogInteractor
import com.ling.mvp.ui.feed.blog.interactor.BlogMvpInteractor
import com.ling.mvp.ui.feed.blog.presenter.BlogMvpPresenter
import com.ling.mvp.ui.feed.blog.presenter.BlogPresenter
import com.ling.mvp.ui.feed.blog.view.BlogAdapter
import com.ling.mvp.ui.feed.blog.view.BlogFragment
import com.ling.mvp.ui.feed.blog.view.BlogMvpView
import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BlogFragmentModule
 */
@Module
class BlogFragmentModule {

    @Provides
    internal fun provideBlogInteractor(interactor: BlogInteractor): BlogMvpInteractor = interactor

    @Provides
    internal fun provideBlogPresenter(presenter: BlogPresenter<BlogMvpView, BlogMvpInteractor>)
            : BlogMvpPresenter<BlogMvpView, BlogMvpInteractor> = presenter

    @Provides
    internal fun provideBlogAdapter(): BlogAdapter = BlogAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: BlogFragment): LinearLayoutManager =
        LinearLayoutManager(fragment.activity)
}
