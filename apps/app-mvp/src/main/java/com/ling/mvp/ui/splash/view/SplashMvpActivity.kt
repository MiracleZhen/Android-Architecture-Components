package com.ling.mvp.ui.splash.view

import android.content.Intent
import android.os.Bundle
import com.ling.mvp.databinding.ActivitySplashBinding
import com.ling.mvp.ui.base.view.BaseActivity
import com.ling.mvp.ui.login.view.LoginActivity
import com.ling.mvp.ui.main.view.MainActivity
import com.ling.mvp.ui.splash.interactor.SplashMvpInteractor
import com.ling.mvp.ui.splash.presenter.SplashMvpPresenter
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : SplashMvpActivity
 */
class SplashMvpActivity : BaseActivity<ActivitySplashBinding>(), SplashMvpView {

    @Inject
    lateinit var presenter: SplashMvpPresenter<SplashMvpView, SplashMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun initView() {

    }

    override fun initData() {

    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    override fun showSuccessToast() {

    }

    override fun showErrorToast() {

    }

    override fun openMainActivity() {
        startActivity(MainActivity::class.java)
        finish()
    }

    override fun openLoginActivity() {
        startActivity(LoginActivity::class.java)
        finish()
    }
}
