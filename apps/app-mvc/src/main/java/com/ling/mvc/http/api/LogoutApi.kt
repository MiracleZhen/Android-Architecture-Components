package com.ling.mvc.http.api

import com.ling.http.config.IRequestApi

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/8
 * desc   : 退出登录
 */
class LogoutApi : IRequestApi {

    override fun getApi(): String {
        return "user/logout"
    }
}
