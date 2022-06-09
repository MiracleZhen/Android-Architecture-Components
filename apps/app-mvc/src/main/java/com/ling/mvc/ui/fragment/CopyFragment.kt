package com.ling.mvc.ui.fragment

import com.ling.common.app.AppFragment
import com.ling.mvc.R
import com.ling.mvc.ui.activity.CopyActivity

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/9
 * desc   : 可进行拷贝的副本
 */
class CopyFragment : AppFragment<CopyActivity>() {

    companion object {

        fun newInstance(): CopyFragment {
            return CopyFragment()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.copy_fragment
    }

    override fun initView() {}

    override fun initData() {}
}
