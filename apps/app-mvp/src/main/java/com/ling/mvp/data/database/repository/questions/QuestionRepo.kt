package com.ling.mvp.data.database.repository.questions

import io.reactivex.Observable

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : QuestionRepo
 */
interface QuestionRepo {

    fun isQuestionsRepoEmpty(): Observable<Boolean>

    fun insertQuestions(questions: List<Question>): Observable<Boolean>

    fun loadQuestions(): Observable<List<Question>>
}
