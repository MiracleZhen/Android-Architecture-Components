package com.ling.mvp.ui.feed

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ling.mvp.ui.feed.blog.view.BlogFragment
import com.ling.mvp.ui.feed.opensource.view.OpenSourceFragment

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : FeedPagerAdapter
 */
class FeedPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var tabCount = 0

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> BlogFragment.newInstance()
            1 -> OpenSourceFragment.newInstance()
            else -> OpenSourceFragment.newInstance()
        }
    }

    internal fun setCount(count: Int) {
        this.tabCount = count
    }
}
