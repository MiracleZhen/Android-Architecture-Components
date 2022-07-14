package com.ling.mvp.ui.base.view

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.ling.common.app.binding.AppBindingFragment
import com.ling.mvp.utils.CommonUtils
import dagger.android.support.AndroidSupportInjection

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : BaseFragment
 */
abstract class BaseFragment<A : BaseActivity<*>, VB : ViewBinding> : AppBindingFragment<A, VB>(), MvpView {

    private var progressDialog: ProgressDialog? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getAttachActivity()?.onFragmentAttached()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onDetach() {
        super.onDetach()
        tag?.let { getAttachActivity()?.onFragmentDetached(it) }
    }

    private fun performDependencyInjection() = AndroidSupportInjection.inject(this)

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showLoadingDialog(getAttachActivity())
    }

    override fun hideProgress() {
        progressDialog?.let {
            if (it.isShowing) {
                it.cancel()
            }
        }
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}
