package com.ling.common.app

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import com.ling.base.BaseApplication
import com.ling.common.manager.ActivityManager
import com.ling.utils.AppUtils
import com.ling.utils.Utils

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/5/18
 * desc   : 应用入口
 */
open class AppApplication : BaseApplication() {

    override fun initSdk(application: Application) {
        // Utils 初始化
        initUtils(application)

        // Activity 栈管理初始化
        ActivityManager.getInstance().init(application)
    }

    private fun initUtils(application: Application) {
        // Utils 初始化
        Utils.init(application)

        // Debug 环境开启 StrictMode 模式
        if (AppUtils.isAppDebug() && false) {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
                // 检测读写操作
                .detectDiskReads()
                .detectDiskWrites()
                // 检测网络操作
                .detectNetwork()
                // 违规则打印日志
                .penaltyLog()
                // 违规则崩溃
                // .penaltyDeath()
                .build())
            StrictMode.setVmPolicy(VmPolicy.Builder()
                .detectActivityLeaks()
                // 检测Sqlite对象泄漏
                .detectLeakedSqlLiteObjects()
                // 检测未关闭的Closable对象泄漏
                .detectLeakedClosableObjects()
                // 违规则打印日志
                .penaltyLog()
                // 违规则崩溃
                // .penaltyDeath()
                .build())
        }
    }
}
