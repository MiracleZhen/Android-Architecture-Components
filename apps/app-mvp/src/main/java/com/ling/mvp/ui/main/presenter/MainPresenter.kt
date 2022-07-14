package com.ling.mvp.ui.main.presenter

import com.ling.mvp.ui.base.presenter.BasePresenter
import com.ling.mvp.ui.main.interactor.MainMvpInteractor
import com.ling.mvp.ui.main.view.MainMvpView
import com.ling.mvp.utils.SchedulerProvider
import com.ling.utils.AppUtils
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : MainPresenter
 */
class MainPresenter<V : MainMvpView, I : MainMvpInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), MainMvpPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getUserData()
        getQuestionCards()
    }

    override fun refreshQuestionCards() = getQuestionCards()

    override fun onDrawerOptionAboutClick(): Unit? = getView()?.openAboutFragment()

    override fun onDrawerOptionRateUsClick(): Unit? = getView()?.openRateUsDialog()

    override fun onDrawerOptionFeedClick(): Unit? = getView()?.openFeedActivity()

    override fun onDrawerOptionLogoutClick() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.makeLogoutApiCall()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({
                    interactor?.performUserLogout()
                    getView()?.let { v ->
                        v.hideProgress()
                        v.openLoginActivity()
                    }
                }, { error ->
                    println(error)
                    if (AppUtils.isAppDebug()) {
                        interactor?.performUserLogout()
                        getView()?.let { v ->
                            v.hideProgress()
                            v.openLoginActivity()
                        }
                    }
                }))
        }
    }

    private fun getUserData() = interactor?.let {
        val userData = it.getUserDetails()
        getView()?.inflateUserDetails(userData)
    }

    private fun getQuestionCards() = interactor?.let {
        compositeDisposable.add(it.getQuestionCardData()
            .compose(schedulerProvider.ioToMainSingleScheduler())
            .subscribe({ questionCard ->
                getView()?.let { v ->
                    if (questionCard.isEmpty()) return@subscribe
                    else v.displayQuestionCard(questionCard)
                }
            }, { error -> println(error) }))
    }
}
