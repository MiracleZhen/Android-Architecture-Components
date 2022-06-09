package com.ling.common.app.binding

import androidx.viewbinding.ViewBinding
import com.ling.base.binding.BaseBindingFragment
import com.ling.common.app.action.ToastAction

/**
 * author : wangchengzhen
 * github : https://github.com/chengzhen-wang/Android-Architecture-Components
 * time   : 2022/5/19
 * desc   : Fragment 业务基类 (封装ViewBinding)
 */
abstract class AppBindingFragment<A : AppBindingActivity<*>, VB : ViewBinding> :
    BaseBindingFragment<A, VB>(), ToastAction {

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
