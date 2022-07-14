package com.ling.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : OpenSource
 */
data class OpenSource(
    @Expose
    @SerializedName("title")
    var title: String? = null,

    @Expose
    @SerializedName("description")
    var description: String? = null,

    @Expose
    @SerializedName("project_url")
    var projectUrl: String? = null,

    @Expose
    @SerializedName("img_url")
    var coverImgUrl: String? = null
)
