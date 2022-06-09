package com.ling.mvc.http.api

import com.ling.http.config.IRequestApi
import java.io.File

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/8
 * desc   : 上传图片
 */
class UpdateImageApi : IRequestApi {

    override fun getApi(): String {
        return "update/image"
    }

    /** 图片文件 */
    private var image: File? = null

    fun setImage(image: File?): UpdateImageApi = apply {
        this.image = image
    }
}
