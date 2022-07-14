package com.ling.mvp.ui.feed.view

import com.google.android.material.tabs.TabLayout
import com.ling.mvp.R
import com.ling.mvp.databinding.ActivityFeedBinding
import com.ling.mvp.ui.base.view.BaseActivity
import com.ling.mvp.ui.feed.FeedPagerAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : FeedActivity
 */
class FeedActivity : BaseActivity<ActivityFeedBinding>(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private lateinit var feedPagerAdapter: FeedPagerAdapter

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun initView() {
        binding?.tabLayout?.apply {
            addTab(binding?.tabLayout?.newTab()!!.setText(R.string.blogs))
            addTab(binding?.tabLayout?.newTab()!!.setText(R.string.open_source))
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    binding?.feedViewPager?.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })
        }
        feedPagerAdapter = FeedPagerAdapter(supportFragmentManager).apply {
            count = 2
        }
        binding?.feedViewPager?.apply {
            adapter = feedPagerAdapter
            offscreenPageLimit = binding?.tabLayout?.tabCount ?: 0
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding?.tabLayout))
        }
    }

    override fun initData() {

    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }
}
