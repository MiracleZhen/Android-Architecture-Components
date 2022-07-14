package com.ling.mvp.ui.feed.blog.interactor

import com.ling.mvp.data.network.model.BlogResponse
import com.ling.mvp.ui.base.interactor.MvpInteractor
import io.reactivex.Observable

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BlogMvpInteractor
 */
interface BlogMvpInteractor : MvpInteractor {

    fun getBlogList(): Observable<BlogResponse>
}
