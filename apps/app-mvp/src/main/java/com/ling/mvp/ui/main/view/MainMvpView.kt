package com.ling.mvp.ui.main.view

import com.ling.mvp.ui.base.view.MvpView
import com.ling.mvp.ui.main.interactor.QuestionCardData

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : MainMvpView
 */
interface MainMvpView : MvpView {

    fun inflateUserDetails(userDetails: Pair<String?, String?>)

    fun displayQuestionCard(questionCardList: List<QuestionCardData>)

    fun openLoginActivity()

    fun openFeedActivity()

    fun openAboutFragment()

    fun openRateUsDialog(): Unit?

    fun lockDrawer(): Unit?

    fun unlockDrawer(): Unit?
}
