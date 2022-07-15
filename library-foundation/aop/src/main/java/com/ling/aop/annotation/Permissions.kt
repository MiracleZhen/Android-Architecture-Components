package com.ling.aop.annotation

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/7
 * desc   : 权限申请注解
 */
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER)
annotation class Permissions constructor(
    /**
     * 需要申请权限的集合
     */
    vararg val value: String
)
