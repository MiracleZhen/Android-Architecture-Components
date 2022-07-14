package com.ling.mvp.ui.rate.interactor

import com.ling.mvp.data.network.ApiHelper
import com.ling.mvp.data.preferences.PreferenceHelper
import com.ling.mvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : RateUsInteractor
 */
class RateUsInteractor @Inject internal constructor(
    prefHelper: PreferenceHelper,
    apiHelper: ApiHelper)
    : BaseInteractor(prefHelper, apiHelper), RateUsMvpInterator {

    override fun submitRating() {
    }
}
