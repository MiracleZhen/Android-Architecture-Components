package com.ling.mvp.ui.splash.presenter

import com.ling.mvp.ui.base.presenter.BasePresenter
import com.ling.mvp.ui.splash.interactor.SplashMvpInteractor
import com.ling.mvp.ui.splash.view.SplashMvpView
import com.ling.mvp.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : SplashPresenter
 */
class SplashPresenter<V : SplashMvpView, I : SplashMvpInteractor> @Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
    SplashMvpPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        feedInDatabase()
    }

    private fun feedInDatabase() = interactor?.let {
        compositeDisposable.add(it.seedQuestions()
            .flatMap { interactor?.seedOptions() }
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe {
                getView()?.let { decideActivityToOpen() }
            })
    }

    private fun decideActivityToOpen() = getView()?.let {
        if (isUserLoggedIn()) {
            it.openMainActivity()
        } else {
            it.openLoginActivity()
        }
    }

    private fun isUserLoggedIn(): Boolean {
        interactor?.let { return it.isUserLoggedIn() }
        return false
    }
}
