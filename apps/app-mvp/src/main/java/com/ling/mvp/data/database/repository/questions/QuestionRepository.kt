package com.ling.mvp.data.database.repository.questions

import io.reactivex.Observable
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : QuestionRepository
 */
class QuestionRepository @Inject internal constructor(private val questionsDao: QuestionDao) : QuestionRepo {

    override fun isQuestionsRepoEmpty(): Observable<Boolean> {
        return Observable.fromCallable { questionsDao.loadAll().isEmpty() }
    }

    override fun insertQuestions(questions: List<Question>): Observable<Boolean> {
        questionsDao.insertAll(questions)
        return Observable.just(true)
    }

    override fun loadQuestions(): Observable<List<Question>> {
        return Observable.fromCallable { questionsDao.loadAll() }
    }
}
