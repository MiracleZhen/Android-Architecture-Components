package com.ling.mvp.ui.login.view

import android.os.Bundle
import android.widget.Toast
import com.ling.mvp.R
import com.ling.mvp.app.AppConstants
import com.ling.mvp.databinding.ActivityLoginV2Binding
import com.ling.mvp.ui.base.view.BaseActivity
import com.ling.mvp.ui.login.interactor.LoginMvpInteractor
import com.ling.mvp.ui.login.presenter.LoginMvpPresenter
import com.ling.mvp.ui.main.view.MainActivity
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : LoginActivity
 */
class LoginActivity : BaseActivity<ActivityLoginV2Binding>(), LoginMvpView {

    @Inject
    internal lateinit var presenter: LoginMvpPresenter<LoginMvpView, LoginMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun initView() {
        binding?.btnServerLogin?.setOnClickListener {
            presenter.onServerLoginClicked(binding?.etEmail?.text.toString(), binding?.etPassword?.text.toString())
        }
        binding?.btnGoogleLogin?.setOnClickListener { presenter.onGoogleLoginClicked() }
        binding?.btnFbLogin?.setOnClickListener { presenter.onFBLoginClicked() }
    }

    override fun initData() {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    override fun showValidationMessage(errorCode: Int) {
        when (errorCode) {
            AppConstants.EMPTY_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.empty_email_error_message), Toast.LENGTH_SHORT).show()
            AppConstants.INVALID_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.invalid_email_error_message), Toast.LENGTH_SHORT).show()
            AppConstants.EMPTY_PASSWORD_ERROR -> Toast.makeText(this, getString(R.string.empty_password_error_message), Toast.LENGTH_SHORT).show()
            AppConstants.LOGIN_FAILURE -> Toast.makeText(this, getString(R.string.login_failure), Toast.LENGTH_SHORT).show()
        }
    }

    override fun openMainActivity() {
        startActivity(MainActivity::class.java)
        finish()
    }
}
