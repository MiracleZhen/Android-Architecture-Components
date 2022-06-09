package com.ling.mvc.http.model

import com.ling.http.config.IRequestServer
import com.ling.http.model.BodyType
import com.ling.mvc.config.AppConfig

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/8
 * desc   : 服务器配置
 */
class RequestServer : IRequestServer {

    override fun getHost(): String {
        return AppConfig.getHostUrl()
    }

    override fun getBodyType(): BodyType {
        // 以表单的形式提交参数
        return BodyType.FORM
    }
}
