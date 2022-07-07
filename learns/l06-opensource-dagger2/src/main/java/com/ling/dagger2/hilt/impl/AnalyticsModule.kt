package com.ling.dagger2.hilt.impl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : 第三步：通过`@Binds`将告知`AnalyticsService`的实现为`AnalyticsServiceImpl`
 * https://www.jianshu.com/p/a301a8d93583
 */
@InstallIn(ActivityComponent::class)
@Module
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAnalyticsService(analyticsServiceImpl: AnalyticsServiceImpl): AnalyticsService
}
