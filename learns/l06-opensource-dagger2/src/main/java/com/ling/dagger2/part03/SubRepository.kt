package com.ling.dagger2.part03

import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : SubRepository
 */
class SubRepository {

    @Inject
    lateinit var localSource: LocalSource

    init {
        // 1.实例化所依赖的Component。
        val dependencyComponent = DaggerDependencyComponent.create()
        // 2.在构建时传入依赖的Component实例。
        val sourceComponent = DaggerSourceComponent.builder()
            .dependencyComponent(dependencyComponent)
            .build()
        // 3.获取SubComponent。
        val subSourceComponent = sourceComponent.getSubSourceComponent()
        // 4.完成依赖注入。
        subSourceComponent.inject(this)
    }

    fun getLocalData(): String {
        return localSource.getLocalData()
    }
}
