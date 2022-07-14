package com.ling.mvp.data.database.repository.options

import io.reactivex.Observable
import io.reactivex.Single

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : OptionRepo
 */
interface OptionRepo {

    fun isOptionsRepoEmpty(): Observable<Boolean>

    fun insertOptions(options: List<Option>): Observable<Boolean>

    fun loadOptions(questionId: Long): Single<List<Option>>
}
