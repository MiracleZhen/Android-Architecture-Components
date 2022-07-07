package com.ling.dagger2.part03

import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : DataRepository
 */
class DataRepository {

    @Inject
    lateinit var dependencySource: DependencySource

    init {
        // 1.实例化所依赖的Component。
        val dependencyComponent = DaggerDependencyComponent.create()
        // 2.在构建时传入依赖的Component实例。
        DaggerSourceComponent.builder()
            .dependencyComponent(dependencyComponent)
            .build()
            .inject(this)
    }

    fun getDependencyData(): String {
        return dependencySource.getData()
    }
}
