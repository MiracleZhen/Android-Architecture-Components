package com.ling.mvp.ui.feed.opensource.view

import com.ling.mvp.data.network.model.OpenSource
import com.ling.mvp.ui.base.view.MvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : OpenSourceMvpView
 */
interface OpenSourceMvpView : MvpView {

    fun displayOpenSourceList(OpenSources: List<OpenSource>?)
}
