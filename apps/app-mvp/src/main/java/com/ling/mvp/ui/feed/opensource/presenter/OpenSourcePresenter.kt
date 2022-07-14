package com.ling.mvp.ui.feed.opensource.presenter

import com.ling.mvp.ui.base.presenter.BasePresenter
import com.ling.mvp.ui.feed.opensource.interactor.OpenSourceMvpInteractor
import com.ling.mvp.ui.feed.opensource.view.OpenSourceMvpView
import com.ling.mvp.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : OpenSourcePresenter
 */
class OpenSourcePresenter<V : OpenSourceMvpView, I : OpenSourceMvpInteractor> @Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), OpenSourceMvpPresenter<V, I> {

    override fun onViewPrepared() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.getOpenSourceList()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ openSourceResponse ->
                    getView()?.let { v ->
                        v.hideProgress()
                        v.displayOpenSourceList(openSourceResponse.data)
                    }
                }, { error ->
                    println(error)
                    getView()?.hideProgress()
                }))
        }
    }
}
