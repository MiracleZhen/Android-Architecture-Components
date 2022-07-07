package com.ling.dagger2.part04.activity

import com.ling.dagger2.part04.app.ScopeAppComponent
import com.ling.dagger2.part04.fragment.ScopeFragmentComponent
import dagger.Component

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ScopeActivityComponent
 */
@PerScopeActivity
@Component(modules = [ScopeActivityModule::class], dependencies = [ScopeAppComponent::class])
interface ScopeActivityComponent {

    fun inject(scopeActivity: ScopeActivity)

    fun scopeFragmentComponent(): ScopeFragmentComponent
}
