package com.ling.mvp.ui.feed.blog.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ling.mvp.data.network.model.Blog
import com.ling.mvp.databinding.FragmentBlogBinding
import com.ling.mvp.ui.base.view.BaseFragment
import com.ling.mvp.ui.feed.blog.interactor.BlogMvpInteractor
import com.ling.mvp.ui.feed.blog.presenter.BlogMvpPresenter
import com.ling.mvp.ui.feed.view.FeedActivity
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BlogFragment
 */
class BlogFragment : BaseFragment<FeedActivity, FragmentBlogBinding>(), BlogMvpView {

    companion object {

        fun newInstance(): BlogFragment {
            return BlogFragment()
        }
    }

    @Inject
    internal lateinit var presenter: BlogMvpPresenter<BlogMvpView, BlogMvpInteractor>

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    @Inject
    internal lateinit var blogAdapter: BlogAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
    }

    override fun initView() {
        binding?.blogRecyclerView?.apply {
            this@BlogFragment.layoutManager.orientation = LinearLayoutManager.VERTICAL
            layoutManager = this@BlogFragment.layoutManager
            itemAnimator = DefaultItemAnimator()
            adapter = blogAdapter
        }
    }

    override fun initData() {
        presenter.onViewPrepared()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDetach()
    }

    override fun displayBlogList(blogs: List<Blog>?): Unit? = blogs?.let {
        blogAdapter.addBlogsToList(it)
    }
}
