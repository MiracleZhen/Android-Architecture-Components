package com.ling.dagger2.part04.fragment

import dagger.Subcomponent

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : ScopeFragmentComponent
 */
@PerScopeFragment
@Subcomponent(modules = [ScopeFragmentModule::class])
interface ScopeFragmentComponent {

    fun inject(scopeFragment: ScopeFragment)
}
