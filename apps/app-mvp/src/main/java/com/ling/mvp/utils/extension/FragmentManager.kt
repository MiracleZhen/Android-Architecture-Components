package com.ling.mvp.utils.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ling.mvp.R

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : FragmentManager
 */
internal fun FragmentManager.addFragment(containerViewId: Int,
                                         fragment: Fragment,
                                         tag: String,
                                         slideIn: Int = R.anim.slide_left,
                                         slideOut: Int = R.anim.slide_right) {
    this.beginTransaction()
        .disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .add(containerViewId, fragment, tag)
        .commit()
}

internal fun FragmentManager.removeFragment(tag: String,
                                            slideIn: Int = R.anim.slide_left,
                                            slideOut: Int = R.anim.slide_right) {
    this.apply {
        val beginTransaction = beginTransaction()
        beginTransaction.disallowAddToBackStack()
        beginTransaction.setCustomAnimations(slideIn, slideOut)
        this.findFragmentByTag(tag)?.let { beginTransaction.remove(it) }
        beginTransaction.commitNow()
    }
    /*this.beginTransaction()
        .disallowAddToBackStack()
        .setCustomAnimations(slideIn, slideOut)
        .remove(this.findFragmentByTag(tag))
        .commitNow()*/
}
