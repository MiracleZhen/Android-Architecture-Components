package com.ling.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : LogoutResponse
 */
data class LogoutResponse internal constructor(
    @Expose
    @SerializedName("status_code")
    private var statusCode: String? = null,

    @Expose
    @SerializedName("message")
    private var message: String? = null
)
