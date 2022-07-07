package com.ling.dagger2.part04.fragment

import javax.inject.Scope

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : PerScopeFragment - 每个Fragment只有一个实例。
 */
@Scope
@Retention
annotation class PerScopeFragment
