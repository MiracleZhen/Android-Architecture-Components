package com.ling.mvp.ui.base.interactor

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : MvpInteractor
 */
interface MvpInteractor {

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()
}
