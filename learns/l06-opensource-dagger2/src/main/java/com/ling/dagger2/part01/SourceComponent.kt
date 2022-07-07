package com.ling.dagger2.part01

import dagger.Component

/**
 * author : wangchengzhen
 * time   : 2022/7/5
 * desc   : 用@Component注解的接口或者抽象类，用于注入依赖
 */
@Component(modules = [RemoteSourceModule::class])
interface SourceComponent {

    fun inject(dataRepository: DataRepository)
}
