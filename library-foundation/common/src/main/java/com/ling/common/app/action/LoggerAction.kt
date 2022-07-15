package com.ling.common.app.action

import android.text.TextUtils
import com.ling.utils.LogUtils

/**
 * author : wangchengzhen
 * github : https://github.com/chengzhen-wang/Android-Architecture-Components
 * time   : 2022/6/7
 * desc   : 日志意图
 */
interface LoggerAction {

    /**
     * Verbose  观察值，Verbose是冗长、啰嗦的意思，任何消息都会输出
     */
    fun logVerbose(tag: String? = null, vararg contents: Any?) {
        if (TextUtils.isEmpty(tag)) {
            LogUtils.v(contents)
        } else {
            LogUtils.vTag(tag, contents)
        }
    }

    /**
     * Debug  调试
     */
    fun logDebug(tag: String? = null, vararg contents: Any?) {
        if (TextUtils.isEmpty(tag)) {
            LogUtils.d(contents)
        } else {
            LogUtils.dTag(tag, contents)
        }
    }

    /**
     * Info  信息，为一般提示性的消息
     */
    fun logInfo(tag: String? = null, vararg contents: Any?) {
        if (TextUtils.isEmpty(tag)) {
            LogUtils.i(contents)
        } else {
            LogUtils.iTag(tag, contents)
        }
    }

    /**
     * Warn  可能会出问题，一般用于系统提示开发者需要优化android代码等场景
     */
    fun logWarn(tag: String? = null, vararg contents: Any?) {
        if (TextUtils.isEmpty(tag)) {
            LogUtils.w(contents)
        } else {
            LogUtils.wTag(tag, contents)
        }
    }

    /**
     * Error  崩溃信息，一般用于输出异常和报错信息
     */
    fun logError(tag: String? = null, vararg contents: Any?) {
        if (TextUtils.isEmpty(tag)) {
            LogUtils.e(contents)
        } else {
            LogUtils.eTag(tag, contents)
        }
    }

    /**
     * Assert  表示断言失败后的错误消息，这类错误原本是不可能出现的错误，现在却出现了，是极其严重的错误类型。
     */
    fun logAssert(tag: String? = null, vararg contents: Any?) {
        if (TextUtils.isEmpty(tag)) {
            LogUtils.a(contents)
        } else {
            LogUtils.aTag(tag, contents)
        }
    }
}
