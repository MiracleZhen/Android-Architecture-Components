package com.ling.dagger2.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ActivityModule
 */
@InstallIn(ActivityComponent::class)
@Module
class ActivityModule {

    @Named("activityName")
    @ActivityScoped
    @Provides
    fun provideName(): String {
        return "activity name"
    }
}
