package com.ling.mvp.ui.feed.opensource.presenter

import com.ling.mvp.ui.base.presenter.MvpPresenter
import com.ling.mvp.ui.feed.opensource.interactor.OpenSourceMvpInteractor
import com.ling.mvp.ui.feed.opensource.view.OpenSourceMvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : OpenSourceMvpPresenter
 */
interface OpenSourceMvpPresenter<V : OpenSourceMvpView, I : OpenSourceMvpInteractor> : MvpPresenter<V, I> {

    fun onViewPrepared()
}
