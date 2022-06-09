package com.ling.mvc.http.api

import com.ling.http.config.IRequestApi

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/8
 * desc   : 获取用户信息
 */
class UserInfoApi : IRequestApi {

    override fun getApi(): String {
        return "user/info"
    }

    class Bean {

    }
}
