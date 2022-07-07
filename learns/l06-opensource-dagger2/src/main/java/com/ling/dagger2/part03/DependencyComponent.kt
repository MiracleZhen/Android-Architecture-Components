package com.ling.dagger2.part03

import dagger.Component

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : DependencyComponent
 */
@Component(modules = [DependencyModule::class])
interface DependencyComponent {

    fun getDependencySource(): DependencySource
}
