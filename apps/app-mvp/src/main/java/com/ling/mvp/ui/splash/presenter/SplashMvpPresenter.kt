package com.ling.mvp.ui.splash.presenter

import com.ling.mvp.ui.base.presenter.MvpPresenter
import com.ling.mvp.ui.splash.interactor.SplashMvpInteractor
import com.ling.mvp.ui.splash.view.SplashMvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : SplashMvpPresenter
 */
interface SplashMvpPresenter<V : SplashMvpView, I : SplashMvpInteractor> : MvpPresenter<V, I>
