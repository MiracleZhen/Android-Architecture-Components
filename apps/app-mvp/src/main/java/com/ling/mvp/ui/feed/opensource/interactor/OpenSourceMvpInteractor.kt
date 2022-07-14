package com.ling.mvp.ui.feed.opensource.interactor

import com.ling.mvp.data.network.model.OpenSourceResponse
import com.ling.mvp.ui.base.interactor.MvpInteractor
import io.reactivex.Observable

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : OpenSourceMvpInteractor
 */
interface OpenSourceMvpInteractor : MvpInteractor {

    fun getOpenSourceList(): Observable<OpenSourceResponse>
}
