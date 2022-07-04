package com.ling.coroutine.api.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ling.coroutine.api.ArticleApi
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * author : wangchengzhen
 * time   : 2022/6/22
 * desc   : Model 层：编写仓库类，获取数据
 */
class ArticleRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.wanandroid.com/")
        .client(OkHttpClient.Builder().addInterceptor {
            it.proceed(it.request()).apply {
                Log.d("~~~", "request ${code()}")
            }
        }.build())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    suspend fun getArticle(): String {
        val articleApi = retrofit.create(ArticleApi::class.java)
        val response = articleApi.getHomeArticles(0)
        Log.d("~~~", "getArticle: $response")
        return response.data.datas.first().title
    }
}
