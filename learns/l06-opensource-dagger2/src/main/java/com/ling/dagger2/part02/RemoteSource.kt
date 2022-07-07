package com.ling.dagger2.part02

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : 网络数据源
 */
class RemoteSource : Source {

    override fun getData(): String {
        return "读取网络数据成功"
    }
}
