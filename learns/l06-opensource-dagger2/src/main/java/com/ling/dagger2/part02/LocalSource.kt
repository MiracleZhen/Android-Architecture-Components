package com.ling.dagger2.part02

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : 本地数据源
 */
class LocalSource : Source {

    override fun getData(): String {
        return "读取本地数据成功"
    }
}
