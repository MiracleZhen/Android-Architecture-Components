package com.ling.mvp.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.ling.common.app.binding.AppBindingActivity
import com.ling.mvp.utils.CommonUtils
import dagger.android.AndroidInjection

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : BaseActivity
 */
abstract class BaseActivity<VB : ViewBinding> : AppBindingActivity<VB>(), MvpView, BaseFragment.Callback {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
    }

    private fun performDI() = AndroidInjection.inject(this)

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showLoadingDialog(this)
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }
}
