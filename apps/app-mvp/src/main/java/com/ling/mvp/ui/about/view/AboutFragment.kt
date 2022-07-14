package com.ling.mvp.ui.about.view

import com.ling.mvp.databinding.FragmentAboutBinding
import com.ling.mvp.ui.base.view.BaseFragment
import com.ling.mvp.ui.main.view.MainActivity

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : AboutFragment
 */
class AboutFragment : BaseFragment<MainActivity, FragmentAboutBinding>() {

    companion object {

        internal const val TAG = "AboutFragment"

        fun newInstance(): AboutFragment {
            return AboutFragment()
        }
    }

    override fun initView() {
        binding?.navBackBtn?.setOnClickListener {
            getAttachActivity()?.onFragmentDetached(TAG)
        }
    }

    override fun initData() {

    }
}
