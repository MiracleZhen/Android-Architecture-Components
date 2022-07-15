package com.ling.aop.aspect

import android.annotation.SuppressLint
import android.app.Application
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat
import com.ling.aop.R
import com.ling.aop.annotation.CheckNet
import com.ling.common.manager.ActivityManager
import com.ling.toast.ToastUtils
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/7
 * desc   : 网络检测切面
 */
@Suppress("unused")
@Aspect
class CheckNetAspect {

    /**
     * 方法切入点
     */
    @Pointcut("execution(@com.ling.aop.annotation.CheckNet * *(..))")
    fun method() {
    }

    /**
     * 在连接点进行方法替换
     */
    @SuppressLint("MissingPermission")
    @Around("method() && @annotation(checkNet)")
    @Throws(Throwable::class)
    fun aroundJoinPoint(joinPoint: ProceedingJoinPoint, checkNet: CheckNet) {
        val application: Application = ActivityManager.getInstance().getApplication()
        val manager: ConnectivityManager? = ContextCompat.getSystemService(application, ConnectivityManager::class.java)
        if (manager != null) {
            val info: NetworkInfo? = manager.activeNetworkInfo
            // 判断网络是否连接
            if (info == null || !info.isConnected) {
                ToastUtils.show(R.string.common_network_hint)
                return
            }
        }
        // 执行原方法
        joinPoint.proceed()
    }
}
