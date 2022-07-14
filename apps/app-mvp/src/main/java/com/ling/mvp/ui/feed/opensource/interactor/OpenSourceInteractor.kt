package com.ling.mvp.ui.feed.opensource.interactor

import com.ling.mvp.data.network.ApiHelper
import com.ling.mvp.data.network.model.OpenSourceResponse
import com.ling.mvp.data.preferences.PreferenceHelper
import com.ling.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : OpenSourceInteractor
 */
class OpenSourceInteractor @Inject internal constructor(
    prefHelper: PreferenceHelper,
    apiHelper: ApiHelper)
    : BaseInteractor(prefHelper, apiHelper), OpenSourceMvpInteractor {

    override fun getOpenSourceList(): Observable<OpenSourceResponse> {
        return apiHelper.getOpenSourceApiCall()
    }
}
