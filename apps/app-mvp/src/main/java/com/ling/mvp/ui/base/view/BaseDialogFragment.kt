package com.ling.mvp.ui.base.view

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ling.mvp.utils.CommonUtils
import dagger.android.support.AndroidSupportInjection

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : BaseDialogFragment
 */
abstract class BaseDialogFragment : DialogFragment(), DialogMvpView {

    private var parentActivity: BaseActivity<*>? = null
    private var progressDialog: ProgressDialog? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            val activity = context as BaseActivity<*>?
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDependencyInjection()
    }

    override fun show(manager: FragmentManager, tag: String?) {
        val transaction = manager.beginTransaction()

        manager.findFragmentByTag(tag)?.apply {
            transaction.remove(this)
        }
        transaction.addToBackStack(null)
        show(transaction, tag)
    }

    fun dismissDialog(tag: String) {
        dismiss()
        getBaseActivity()?.onFragmentDetached(tag)
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    private fun getBaseActivity(): BaseActivity<*>? {
        return parentActivity
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showLoadingDialog(this.context)
    }

    override fun hideProgress() {
        progressDialog?.let {
            if (it.isShowing) {
                it.cancel()
            }
        }
    }
}
