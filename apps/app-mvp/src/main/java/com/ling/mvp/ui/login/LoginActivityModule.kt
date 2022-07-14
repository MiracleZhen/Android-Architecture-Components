package com.ling.mvp.ui.login

import com.ling.mvp.ui.login.interactor.LoginInteractor
import com.ling.mvp.ui.login.interactor.LoginMvpInteractor
import com.ling.mvp.ui.login.presenter.LoginMvpPresenter
import com.ling.mvp.ui.login.presenter.LoginPresenter
import com.ling.mvp.ui.login.view.LoginMvpView
import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : LoginActivityModule
 */
@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractor): LoginMvpInteractor =
        interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginMvpView, LoginMvpInteractor>)
            : LoginMvpPresenter<LoginMvpView, LoginMvpInteractor> = presenter
}
