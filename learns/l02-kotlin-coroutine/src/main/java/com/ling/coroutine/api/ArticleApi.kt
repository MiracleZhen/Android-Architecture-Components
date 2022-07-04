package com.ling.coroutine.api

import com.ling.coroutine.api.bean.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * author : wangchengzhen
 * time   : 2022/6/22
 * desc   : Model 层：编写 Retrofit API
 */
interface ArticleApi {

    @GET("article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): Response
}
