package com.ling.mvp.ui.feed.blog.presenter

import com.ling.mvp.ui.base.presenter.MvpPresenter
import com.ling.mvp.ui.feed.blog.interactor.BlogMvpInteractor
import com.ling.mvp.ui.feed.blog.view.BlogMvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BlogMvpPresenter
 */
interface BlogMvpPresenter<V : BlogMvpView, I : BlogMvpInteractor> : MvpPresenter<V, I> {

    fun onViewPrepared()
}
