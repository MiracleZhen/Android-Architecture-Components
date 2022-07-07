package com.ling.dagger2.part01

import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/5
 * desc   : 本地数据源
 */
class LocalSource @Inject constructor() {

    fun getData(): String {
        return "使用在构造函数上使用 @Inject 的方式，获取到了本地数据"
    }
}
