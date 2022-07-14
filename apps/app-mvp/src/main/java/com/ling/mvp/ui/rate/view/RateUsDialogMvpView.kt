package com.ling.mvp.ui.rate.view

import com.ling.mvp.ui.base.view.MvpView

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : RateUsDialogMvpView
 */
interface RateUsDialogMvpView : MvpView {

    fun showRatingSubmissionSuccessMessage()

    fun dismissDialog()
}
