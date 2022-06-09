package com.ling.common.app.action

import androidx.annotation.StringRes
import com.ling.toast.ToastUtils

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/5/18
 * desc   : 吐司意图
 */
interface ToastAction {

    fun toast(text: CharSequence?) {
        ToastUtils.show(text)
    }

    fun toast(@StringRes id: Int) {
        ToastUtils.show(id)
    }

    fun toast(`object`: Any?) {
        ToastUtils.show(`object`)
    }
}
