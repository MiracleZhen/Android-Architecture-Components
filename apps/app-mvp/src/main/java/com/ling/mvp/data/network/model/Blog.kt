package com.ling.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : Blog
 */
data class Blog(
    @Expose
    @SerializedName("title")
    var title: String? = null,

    @Expose
    @SerializedName("description")
    var description: String? = null,

    @Expose
    @SerializedName("author")
    var author: String? = null,

    @Expose
    @SerializedName("published_at")
    var date: String? = null,

    @Expose
    @SerializedName("blog_url")
    var blogUrl: String? = null,

    @Expose
    @SerializedName("img_url")
    var coverImgUrl: String? = null
)
