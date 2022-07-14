package com.ling.mvp.ui.login.presenter

import com.ling.mvp.ui.base.presenter.MvpPresenter
import com.ling.mvp.ui.login.interactor.LoginMvpInteractor
import com.ling.mvp.ui.login.view.LoginMvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : LoginMvpPresenter
 */
interface LoginMvpPresenter<V : LoginMvpView, I : LoginMvpInteractor> : MvpPresenter<V, I> {

    fun onServerLoginClicked(email: String, password: String)

    fun onFBLoginClicked()

    fun onGoogleLoginClicked()
}
