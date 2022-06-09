package com.ling.mvc.ui.popup

import android.content.Context
import com.ling.base.BasePopupWindow
import com.ling.mvc.R

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/8
 * desc   : 可进行拷贝的副本
 */
class CopyPopup {

    class Builder(context: Context) : BasePopupWindow.Builder<Builder>(context) {

        init {
            setContentView(R.layout.copy_popup)
        }
    }
}
