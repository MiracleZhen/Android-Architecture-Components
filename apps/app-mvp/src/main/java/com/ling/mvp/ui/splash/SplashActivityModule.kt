package com.ling.mvp.ui.splash

import com.ling.mvp.ui.splash.interactor.SplashInteractor
import com.ling.mvp.ui.splash.interactor.SplashMvpInteractor
import com.ling.mvp.ui.splash.presenter.SplashMvpPresenter
import com.ling.mvp.ui.splash.presenter.SplashPresenter
import com.ling.mvp.ui.splash.view.SplashMvpView
import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : SplashActivityModule
 */
@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashInteractor(splashInteractor: SplashInteractor): SplashMvpInteractor =
        splashInteractor

    @Provides
    internal fun provideSplashPresenter(splashPresenter: SplashPresenter<SplashMvpView, SplashMvpInteractor>):
            SplashMvpPresenter<SplashMvpView, SplashMvpInteractor> =
        splashPresenter
}
