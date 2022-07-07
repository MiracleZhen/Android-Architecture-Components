package com.ling.dagger2.part03

import dagger.Component

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : SourceComponent
 */
@Component(modules = [SourceModule::class], dependencies = [DependencyComponent::class])
interface SourceComponent {

    fun inject(dataRepository: DataRepository)

    fun getSubSourceComponent(): SubSourceComponent
}
