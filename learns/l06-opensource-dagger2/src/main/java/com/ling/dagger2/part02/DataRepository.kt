package com.ling.dagger2.part02

import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : 注入目标类
 */
class DataRepository {

    @Local
    // @Named("Local")
    @Inject
    lateinit var localSource: Source

    @Remote
    // @Named("Remote")
    @Inject
    lateinit var remoteSource: Source

    init {
        DaggerSourceComponent.create().inject(this)
    }

    fun getLocalData(): String {
        return localSource.getData()
    }

    fun getRemoteData(): String {
        return remoteSource.getData()
    }
}
