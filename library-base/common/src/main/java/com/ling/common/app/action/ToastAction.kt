package com.ling.common.app.action

import androidx.annotation.StringRes

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/5/18
 * desc   : 吐司意图
 */
interface ToastAction {

    fun toast(text: CharSequence?) {

    }

    fun toast(@StringRes id: Int) {

    }

    fun toast(`object`: Any?) {

    }
}
