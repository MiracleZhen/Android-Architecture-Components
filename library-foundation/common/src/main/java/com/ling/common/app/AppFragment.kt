package com.ling.common.app

import com.ling.base.BaseFragment
import com.ling.common.app.action.ToastAction

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/5/18
 * desc   : Fragment 业务基类
 */
abstract class AppFragment<A : AppActivity> : BaseFragment<A>(), ToastAction {

    /**
     * 显示加载对话框
     */
    open fun showDialog() {
        getAttachActivity()?.showDialog()
    }

    /**
     * 隐藏加载对话框
     */
    open fun hideDialog() {
        getAttachActivity()?.hideDialog()
    }

    /**
     * 当前加载对话框是否在显示中
     */
    open fun isShowDialog(): Boolean {
        val activity: A = getAttachActivity() ?: return false
        return activity.isShowDialog()
    }
}
