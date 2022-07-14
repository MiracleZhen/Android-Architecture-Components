package com.ling.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : OpenSourceResponse
 */
data class OpenSourceResponse(
    @Expose
    @SerializedName("status_code")
    private var statusCode: String? = null,

    @Expose
    @SerializedName("message")
    private var message: String? = null,

    @Expose
    @SerializedName("data")
    var data: List<OpenSource>? = null
)
