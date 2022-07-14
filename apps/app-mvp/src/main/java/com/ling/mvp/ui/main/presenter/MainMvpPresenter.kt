package com.ling.mvp.ui.main.presenter

import com.ling.mvp.ui.base.presenter.MvpPresenter
import com.ling.mvp.ui.main.interactor.MainMvpInteractor
import com.ling.mvp.ui.main.view.MainMvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : MainMvpPresenter
 */
interface MainMvpPresenter<V : MainMvpView, I : MainMvpInteractor> : MvpPresenter<V, I> {

    fun refreshQuestionCards(): Boolean?

    fun onDrawerOptionAboutClick(): Unit?

    fun onDrawerOptionRateUsClick(): Unit?

    fun onDrawerOptionFeedClick(): Unit?

    fun onDrawerOptionLogoutClick()
}
