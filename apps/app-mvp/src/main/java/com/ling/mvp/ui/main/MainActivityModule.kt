package com.ling.mvp.ui.main

import com.ling.mvp.ui.main.interactor.MainInteractor
import com.ling.mvp.ui.main.interactor.MainMvpInteractor
import com.ling.mvp.ui.main.presenter.MainMvpPresenter
import com.ling.mvp.ui.main.presenter.MainPresenter
import com.ling.mvp.ui.main.view.MainMvpView
import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : MainActivityModule
 */
@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMvpInteractor =
        mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMvpView, MainMvpInteractor>)
            : MainMvpPresenter<MainMvpView, MainMvpInteractor> = mainPresenter
}
