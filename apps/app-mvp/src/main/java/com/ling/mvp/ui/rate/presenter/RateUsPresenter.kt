package com.ling.mvp.ui.rate.presenter

import com.ling.mvp.ui.base.presenter.BasePresenter
import com.ling.mvp.ui.rate.interactor.RateUsMvpInterator
import com.ling.mvp.ui.rate.view.RateUsDialogMvpView
import com.ling.mvp.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : RateUsPresenter
 */
class RateUsPresenter<V : RateUsDialogMvpView, I : RateUsMvpInterator> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), RateUsMvpPresenter<V, I> {

    override fun onLaterOptionClicked(): Unit? = getView()?.dismissDialog()

    override fun onSubmitOptionClicked(): Unit? = interactor?.let {
        it.submitRating()
        getView()?.let { v ->
            v.showRatingSubmissionSuccessMessage()
            v.dismissDialog()
        }
    }
}
