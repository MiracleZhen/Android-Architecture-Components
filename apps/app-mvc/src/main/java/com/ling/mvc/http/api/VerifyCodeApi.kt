package com.ling.mvc.http.api

import com.ling.http.config.IRequestApi

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/8
 * desc   : 验证码校验
 */
class VerifyCodeApi : IRequestApi {

    override fun getApi(): String {
        return "code/checkout"
    }

    /** 手机号 */
    private var phone: String? = null

    /** 验证码 */
    private var code: String? = null

    fun setPhone(phone: String?): VerifyCodeApi = apply {
        this.phone = phone
    }

    fun setCode(code: String?): VerifyCodeApi = apply {
        this.code = code
    }
}
