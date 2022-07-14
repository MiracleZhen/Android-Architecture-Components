package com.ling.mvp.data.database.repository.options

import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : OptionRepository
 */
class OptionRepository @Inject constructor(private val optionDao: OptionDao) : OptionRepo {

    override fun isOptionsRepoEmpty(): Observable<Boolean> {
        return Observable.just(optionDao.loadAll().isEmpty())
    }

    override fun insertOptions(options: List<Option>): Observable<Boolean> {
        optionDao.insertAll(options)
        return Observable.just(true)
    }

    override fun loadOptions(questionId: Long): Single<List<Option>> {
        return Single.fromCallable { optionDao.loadOptionsByQuestionId(questionId) }
    }
}
