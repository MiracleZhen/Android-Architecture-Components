package com.ling.mvp.ui.main.interactor

import com.ling.mvp.data.network.model.LogoutResponse
import com.ling.mvp.ui.base.interactor.MvpInteractor
import io.reactivex.Observable
import io.reactivex.Single

/**
 * author : wangchengzhen
 * time   : 2022/7/13
 * desc   : MainMvpInteractor
 */
interface MainMvpInteractor : MvpInteractor {

    fun getQuestionCardData(): Single<List<QuestionCardData>>

    fun getUserDetails(): Pair<String?, String?>

    fun makeLogoutApiCall(): Observable<LogoutResponse>
}
