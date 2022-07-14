package com.ling.mvp.ui.login.view

import com.ling.mvp.ui.base.view.MvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : LoginMvpView
 */
interface LoginMvpView : MvpView {

    fun showValidationMessage(errorCode: Int)

    fun openMainActivity()
}
