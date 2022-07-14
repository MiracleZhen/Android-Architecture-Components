package com.ling.mvp.ui.feed.opensource.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.ling.mvp.data.network.model.OpenSource
import com.ling.mvp.databinding.FragmentOpenSourceBinding
import com.ling.mvp.ui.base.view.BaseFragment
import com.ling.mvp.ui.feed.opensource.interactor.OpenSourceMvpInteractor
import com.ling.mvp.ui.feed.opensource.presenter.OpenSourceMvpPresenter
import com.ling.mvp.ui.feed.view.FeedActivity
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : OpenSourceFragment
 */
class OpenSourceFragment : BaseFragment<FeedActivity, FragmentOpenSourceBinding>(), OpenSourceMvpView {

    companion object {

        fun newInstance(): OpenSourceFragment {
            return OpenSourceFragment()
        }
    }

    @Inject
    internal lateinit var presenter: OpenSourceMvpPresenter<OpenSourceMvpView, OpenSourceMvpInteractor>

    @Inject
    internal lateinit var openSourceAdapter: OpenSourceAdapter

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
    }

    override fun initView() {
        binding?.repoRecyclerView?.apply {
            this@OpenSourceFragment.layoutManager.orientation = LinearLayoutManager.VERTICAL
            layoutManager = this@OpenSourceFragment.layoutManager
            itemAnimator = DefaultItemAnimator()
            adapter = openSourceAdapter
        }
    }

    override fun initData() {
        presenter.onViewPrepared()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDetach()
    }

    override fun displayOpenSourceList(OpenSources: List<OpenSource>?) {
        OpenSources?.let {
            openSourceAdapter.addOpenSourcesToList(it)
        }
    }
}
