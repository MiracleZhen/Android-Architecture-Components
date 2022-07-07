package com.ling.dagger2.part02

import dagger.Component

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : 依赖注入接口
 */
@Component(modules = [SourceModule::class])
interface SourceComponent {

    fun inject(dataRepository: DataRepository)
}
