package com.ling.dagger2.part01

import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/5
 * desc   : 数据仓库
 */
class DataRepository {

    init {
        DaggerSourceComponent.create().inject(this)
    }

    @Inject
    lateinit var localSource: LocalSource

    @Inject
    lateinit var remoteSource: RemoteSource

    fun getData(): String {
        return localSource.getData()
    }

    fun getNetData(): String {
        return remoteSource.getData()
    }
}
