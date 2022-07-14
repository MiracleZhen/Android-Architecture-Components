package com.ling.mvp.ui.base.interactor

import com.ling.mvp.app.AppConstants
import com.ling.mvp.data.network.ApiHelper
import com.ling.mvp.data.preferences.PreferenceHelper

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : BaseInteractor
 */
open class BaseInteractor() : MvpInteractor {

    protected lateinit var prefHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(prefHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.prefHelper = prefHelper
        this.apiHelper = apiHelper
    }

    override fun isUserLoggedIn(): Boolean {
        return this.prefHelper.getCurrentUserLoggedInMode() != AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type
    }

    override fun performUserLogout() {
        this.prefHelper.let {
            it.setAccessToken(null)
            it.setCurrentUserId(null)
            it.setCurrentUserName(null)
            it.setCurrentUserEmail(null)
            it.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
        }
    }
}
