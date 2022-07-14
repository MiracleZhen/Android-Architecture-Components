package com.ling.mvp.ui.login.presenter

import android.util.Log
import com.ling.mvp.app.AppConstants
import com.ling.mvp.data.network.model.LoginResponse
import com.ling.mvp.ui.base.presenter.BasePresenter
import com.ling.mvp.ui.login.interactor.LoginMvpInteractor
import com.ling.mvp.ui.login.view.LoginMvpView
import com.ling.mvp.utils.SchedulerProvider
import com.ling.utils.AppUtils
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : LoginPresenter
 */
class LoginPresenter<V : LoginMvpView, I : LoginMvpInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, disposable), LoginMvpPresenter<V, I> {

    override fun onServerLoginClicked(email: String, password: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.let {
                    compositeDisposable.add(it.doServerLoginApiCall(email, password)
                        .compose(schedulerProvider.ioToMainObservableScheduler())
                        .subscribe({ loginResponse ->
                            updateUserInSharedPref(loginResponse, AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                            getView()?.hideProgress()
                            getView()?.openMainActivity()
                        }, { error ->
                            getView()?.hideProgress()
                            println(error)
                        }))
                }
            }
        }
    }

    override fun onFBLoginClicked() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.doFBLoginApiCall()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ loginResponse ->
                    updateUserInSharedPref(loginResponse, AppConstants.LoggedInMode.LOGGED_IN_MODE_FB)
                    getView()?.let { v ->
                        v.hideProgress()
                        v.openMainActivity()
                    }
                }, { error ->
                    getView()?.hideProgress()
                    println(error)
                }))
        }
    }

    override fun onGoogleLoginClicked() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.doGoogleLoginApiCall()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ loginResponse ->
                    updateUserInSharedPref(loginResponse, AppConstants.LoggedInMode.LOGGED_IN_MODE_GOOGLE)
                    getView()?.let { v ->
                        v.hideProgress()
                        v.openMainActivity()
                    }
                }, { error ->
                    getView()?.hideProgress()
                    println(error)
                    if (AppUtils.isAppDebug()) {
                        val loginResponse = LoginResponse()
                        loginResponse.statusCode = "0"
                        loginResponse.message = "success"
                        loginResponse.accessToken = "111111"
                        loginResponse.userId = 10001
                        loginResponse.userName = "jack"
                        loginResponse.userEmail = "123@gmail.com"
                        loginResponse.serverProfilePicUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2Ftp09%2F210F2130512J47-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1660355725&t=cea8a27ab03bd404f53d9805a14a3da2"
                        loginResponse.fbProfilePicUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2Ftp09%2F210F2130512J47-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1660355725&t=cea8a27ab03bd404f53d9805a14a3da2"
                        loginResponse.googleProfilePicUrl = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2Ftp09%2F210F2130512J47-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1660355725&t=cea8a27ab03bd404f53d9805a14a3da2"
                        updateUserInSharedPref(loginResponse, AppConstants.LoggedInMode.LOGGED_IN_MODE_GOOGLE)
                        getView()?.openMainActivity()
                    }
                }))
        }
    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse,
                                       loggedInMode: AppConstants.LoggedInMode) {
        interactor?.updateUserInSharedPref(loginResponse, loggedInMode)
    }
}
