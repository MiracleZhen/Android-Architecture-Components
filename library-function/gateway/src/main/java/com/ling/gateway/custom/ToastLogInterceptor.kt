package com.ling.gateway.custom

import com.ling.common.app.action.ToastAction
import com.ling.toast.ToastUtils
import com.ling.toast.config.IToastInterceptor
import com.ling.utils.AppUtils

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/6
 * desc   : 自定义 Toast 拦截器（用于追踪 Toast 调用的位置）
 */
class ToastLogInterceptor : IToastInterceptor {

    override fun intercept(text: CharSequence): Boolean {
        // AppConfig.isLogEnable()
        if (AppUtils.isAppDebug()) {
            // 获取调用的堆栈信息
            val stackTrace: Array<StackTraceElement> = Throwable().stackTrace
            // 跳过最前面两个堆栈
            var i = 2
            while (stackTrace.size > 2 && i < stackTrace.size) {

                // 获取代码行数
                val lineNumber: Int = stackTrace[i].lineNumber
                // 获取类的全路径
                val className: String = stackTrace[i].className
                if (((lineNumber <= 0) || className.startsWith(ToastUtils::class.java.name) ||
                            className.startsWith(ToastAction::class.java.name))) {
                    i++
                    continue
                }
                // Timber.tag("ToastUtils")
                // Timber.i("(%s:%s) %s", stackTrace[i].fileName, lineNumber, text.toString())
                break
                i++
            }
        }
        return false
    }
}
