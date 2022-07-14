package com.ling.gateway.app

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.bumptech.glide.Glide
import com.ling.bar.TitleBar
import com.ling.base.BaseApplication
import com.ling.common.app.AppApplication
import com.ling.common.manager.ActivityManager
import com.ling.gateway.R
import com.ling.gateway.custom.*
import com.ling.http.EasyConfig
import com.ling.http.config.IRequestApi
import com.ling.http.config.RequestServer
import com.ling.http.model.HttpHeaders
import com.ling.toast.ToastUtils
import com.ling.utils.AppUtils
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.tencent.mmkv.MMKV

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/6
 * desc   : 应用入口
 */
open class GatewayApplication : AppApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        // 清理所有图片内存缓存
        Glide.get(this).onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        // 根据手机内存剩余情况清理图片内存缓存
        Glide.get(this).onTrimMemory(level)
    }

    /**
     * 初始化一些第三方框架
     */
    @SuppressLint("MissingPermission")
    override fun initSdk(application: Application) {
        super.initSdk(application)
        // 设置标题栏初始化器
        TitleBar.setDefaultStyle(TitleBarStyle())

        // 设置全局的 Header 构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context: Context, layout: RefreshLayout ->
            MaterialHeader(context).setColorSchemeColors(ContextCompat.getColor(context, R.color.common_accent_color))
        }
        // 设置全局的 Footer 构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context: Context, layout: RefreshLayout ->
            SmartBallPulseFooter(context)
        }
        // 设置全局初始化器
        SmartRefreshLayout.setDefaultRefreshInitializer { context: Context, layout: RefreshLayout ->
            // 刷新头部是否跟随内容偏移
            layout.setEnableHeaderTranslationContent(true)
                // 刷新尾部是否跟随内容偏移
                .setEnableFooterTranslationContent(true)
                // 加载更多是否跟随内容偏移
                .setEnableFooterFollowWhenNoMoreData(true)
                // 内容不满一页时是否可以上拉加载更多
                .setEnableLoadMoreWhenContentNotFull(false)
                // 仿苹果越界效果开关
                .setEnableOverScrollDrag(false)
        }

        // 初始化吐司
        ToastUtils.init(application, ToastStyle())
        // 设置调试模式
        ToastUtils.setDebugMode(AppUtils.isAppDebug())
        // 设置 Toast 拦截器
        ToastUtils.setInterceptor(ToastLogInterceptor())

        // 本地异常捕捉
        // CrashHandler.register(application)

        // MMKV 初始化
        MMKV.initialize(application)

        // 注册网络状态变化监听
        val connectivityManager: ConnectivityManager? = ContextCompat.getSystemService(application, ConnectivityManager::class.java)
        if (connectivityManager != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
                override fun onLost(network: Network) {
                    val topActivity: Activity? = ActivityManager.getInstance().getTopActivity()
                    if (topActivity !is LifecycleOwner) {
                        return
                    }
                    val lifecycleOwner: LifecycleOwner = topActivity
                    if (lifecycleOwner.lifecycle.currentState != Lifecycle.State.RESUMED) {
                        return
                    }
                    ToastUtils.show(R.string.common_network_error)
                }
            })
        }
    }
}
