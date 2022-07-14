package com.ling.mvp.ui.splash.view

import com.ling.mvp.ui.base.view.MvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : SplashMvpView
 */
interface SplashMvpView : MvpView {

    fun showSuccessToast()

    fun showErrorToast()

    fun openMainActivity()

    fun openLoginActivity()
}
