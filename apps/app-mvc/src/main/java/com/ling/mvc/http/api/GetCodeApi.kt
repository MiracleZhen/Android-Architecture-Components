package com.ling.mvc.http.api

import com.ling.http.config.IRequestApi

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/8
 * desc   : 获取验证码
 */
class GetCodeApi : IRequestApi {

    override fun getApi(): String {
        return "code/get"
    }

    /** 手机号 */
    private var phone: String? = null

    fun setPhone(phone: String?): GetCodeApi = apply {
        this.phone = phone
    }
}
