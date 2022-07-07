package com.ling.dagger2.part04.activity

import javax.inject.Scope

/**
 * author : wangchengzhen
 * time   : 2022/7/6
 * desc   : PerScopeActivity - 每个Activity只有一个实例。
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerScopeActivity
