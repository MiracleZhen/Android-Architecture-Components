package com.ling.mvp.ui.login.interactor

import com.ling.mvp.app.AppConstants
import com.ling.mvp.data.network.model.LoginResponse
import com.ling.mvp.ui.base.interactor.MvpInteractor
import io.reactivex.Observable

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : LoginMvpInteractor
 */
interface LoginMvpInteractor : MvpInteractor {

    fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse>

    fun doFBLoginApiCall(): Observable<LoginResponse>

    fun doGoogleLoginApiCall(): Observable<LoginResponse>

    fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode)
}
