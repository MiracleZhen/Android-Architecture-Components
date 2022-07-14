package com.ling.mvp.ui.feed.blog.interactor

import com.ling.mvp.data.network.ApiHelper
import com.ling.mvp.data.network.model.BlogResponse
import com.ling.mvp.data.preferences.PreferenceHelper
import com.ling.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BlogInteractor
 */
class BlogInteractor @Inject internal constructor(
    prefHelper: PreferenceHelper,
    apiHelper: ApiHelper)
    : BaseInteractor(prefHelper, apiHelper), BlogMvpInteractor {

    override fun getBlogList(): Observable<BlogResponse> = apiHelper.getBlogApiCall()
}
