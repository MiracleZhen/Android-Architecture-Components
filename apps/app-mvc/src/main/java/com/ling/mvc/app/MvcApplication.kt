package com.ling.mvc.app

import android.app.Application
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonToken
import com.hjq.gson.factory.GsonFactory
import com.ling.aop.annotation.Log
import com.ling.bar.TitleBar
import com.ling.base.BaseApplication
import com.ling.gateway.app.GatewayApplication
import com.ling.http.EasyConfig
import com.ling.http.config.IRequestApi
import com.ling.http.config.IRequestInterceptor
import com.ling.http.model.HttpHeaders
import com.ling.http.model.HttpParams
import com.ling.http.request.HttpRequest
import com.ling.mvc.config.AppConfig
import com.ling.mvc.config.DebugLoggerTree
import com.ling.mvc.http.model.RequestHandler
import com.ling.mvc.http.model.RequestServer
import com.tencent.bugly.crashreport.CrashReport
import okhttp3.OkHttpClient
import timber.log.Timber

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/5/20
 * desc   : 应用入口
 */
class MvcApplication : GatewayApplication() {

    @Log("启动耗时")
    override fun onCreate() {
        super.onCreate()
    }

    /**
     * 初始化一些第三方框架
     */
    override fun initSdk(application: Application) {
        super.initSdk(application)

        // Bugly 异常捕捉
        CrashReport.initCrashReport(application, AppConfig.getBuglyId(), AppConfig.isDebug())

        // 网络请求框架初始化
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .build()
        EasyConfig.with(okHttpClient)
            // 是否打印日志
            .setLogEnabled(AppConfig.isLogEnable())
            // 设置服务器配置
            .setServer(RequestServer())
            // 设置请求处理策略
            .setHandler(RequestHandler(application))
            // 设置请求重试次数
            .setRetryCount(1)
            .setInterceptor(object : IRequestInterceptor {
                override fun interceptArguments(httpRequest: HttpRequest<*>, params: HttpParams, headers: HttpHeaders) {
                    // 添加全局请求头
                    headers.put("token", "66666666666")
                    // headers.put("deviceOaid", UmengClient.getDeviceOaid())
                    headers.put("versionName", AppConfig.getVersionName())
                    headers.put("versionCode", AppConfig.getVersionCode().toString())
                }
            })
            .into()

        // 设置 Json 解析容错监听
        GsonFactory.setJsonCallback { typeToken: TypeToken<*>, fieldName: String?, jsonToken: JsonToken ->
            // 上报到 Bugly 错误列表
            CrashReport.postCatchedException(IllegalArgumentException("类型解析异常：$typeToken#$fieldName，后台返回的类型为：$jsonToken"))
        }

        // 初始化日志打印
        if (AppConfig.isLogEnable()) {
            Timber.plant(DebugLoggerTree())
        }
    }
}
