package com.ling.mvp.ui.splash.interactor

import com.ling.mvp.data.database.repository.questions.Question
import com.ling.mvp.ui.base.interactor.MvpInteractor
import io.reactivex.Observable

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : SplashMvpInteractor
 */
interface SplashMvpInteractor : MvpInteractor {

    fun seedQuestions(): Observable<Boolean>

    fun seedOptions(): Observable<Boolean>

    fun getQuestion(): Observable<List<Question>>
}
