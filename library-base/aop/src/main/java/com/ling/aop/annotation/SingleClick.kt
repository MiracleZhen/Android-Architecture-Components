package com.ling.aop.annotation

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/7
 * desc   : 防重复点击注解
 */
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER)
annotation class SingleClick constructor(
    /**
     * 快速点击的间隔
     */
    val value: Long = 1000
)
