package com.ling.mvp.ui.rate.presenter

import com.ling.mvp.ui.base.presenter.MvpPresenter
import com.ling.mvp.ui.rate.interactor.RateUsMvpInterator
import com.ling.mvp.ui.rate.view.RateUsDialogMvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : RateUsMvpPresenter
 */
interface RateUsMvpPresenter<V : RateUsDialogMvpView, I : RateUsMvpInterator> : MvpPresenter<V, I> {

    fun onLaterOptionClicked(): Unit?

    fun onSubmitOptionClicked(): Unit?
}
