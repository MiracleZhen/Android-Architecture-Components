package com.ling.mvp.ui.rate

import com.ling.mvp.ui.rate.interactor.RateUsInteractor
import com.ling.mvp.ui.rate.interactor.RateUsMvpInterator
import com.ling.mvp.ui.rate.presenter.RateUsMvpPresenter
import com.ling.mvp.ui.rate.presenter.RateUsPresenter
import com.ling.mvp.ui.rate.view.RateUsDialogMvpView
import dagger.Module
import dagger.Provides

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : RateUsFragmentModule
 */
@Module
class RateUsFragmentModule {

    @Provides
    internal fun provideRateUsInteractor(interactor: RateUsInteractor): RateUsMvpInterator =
        interactor

    @Provides
    internal fun provideRateUsPresenter(presenter: RateUsPresenter<RateUsDialogMvpView, RateUsMvpInterator>)
            : RateUsMvpPresenter<RateUsDialogMvpView, RateUsMvpInterator> = presenter
}
