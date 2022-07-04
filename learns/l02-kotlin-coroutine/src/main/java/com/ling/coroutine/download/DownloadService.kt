package com.ling.coroutine.download

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url

/**
 * author : wangchengzhen
 * time   : 2022/7/4
 * desc   : 声明 ApiService 接口
 */
interface DownloadService {

    @Streaming
    @GET
    fun download(@Url url: String): Call<ResponseBody>
}
