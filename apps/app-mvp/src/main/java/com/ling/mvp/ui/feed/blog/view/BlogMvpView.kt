package com.ling.mvp.ui.feed.blog.view

import com.ling.mvp.data.network.model.Blog
import com.ling.mvp.ui.base.view.MvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BlogMvpView
 */
interface BlogMvpView : MvpView {

    fun displayBlogList(blogs: List<Blog>?): Unit?
}
