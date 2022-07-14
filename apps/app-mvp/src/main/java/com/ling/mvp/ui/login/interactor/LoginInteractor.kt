package com.ling.mvp.ui.login.interactor

import com.ling.mvp.app.AppConstants
import com.ling.mvp.data.network.ApiHelper
import com.ling.mvp.data.network.model.LoginRequest
import com.ling.mvp.data.network.model.LoginResponse
import com.ling.mvp.data.preferences.PreferenceHelper
import com.ling.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : LoginInteractor
 */
class LoginInteractor @Inject internal constructor(
    prefHelper: PreferenceHelper,
    apiHelper: ApiHelper) : BaseInteractor(prefHelper, apiHelper), LoginMvpInteractor {

    override fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse> {
        return apiHelper.performServerLogin(LoginRequest.ServerLoginRequest(email, password))
    }

    override fun doFBLoginApiCall(): Observable<LoginResponse> {
        return apiHelper.performFBLogin(LoginRequest.FacebookLoginRequest("test3", "test4"))
    }

    override fun doGoogleLoginApiCall(): Observable<LoginResponse> {
        return apiHelper.performGoogleLogin(LoginRequest.GoogleLoginRequest("test1", "test2"))
    }

    override fun updateUserInSharedPref(loginResponse: LoginResponse, loggedInMode: AppConstants.LoggedInMode) {
        prefHelper.let {
            it.setCurrentUserLoggedInMode(loggedInMode)
            it.setAccessToken(loginResponse.accessToken)
            it.setCurrentUserId(loginResponse.userId)
            it.setCurrentUserName(loginResponse.userName)
            it.setCurrentUserEmail(loginResponse.userEmail)
        }
    }
}
