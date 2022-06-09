package com.ling.mvc.ui.dialog

import android.content.Context
import android.view.Gravity
import com.ling.base.BaseDialog
import com.ling.base.action.AnimAction
import com.ling.mvc.R

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/8
 * desc   : 可进行拷贝的副本
 */
class CopyDialog {

    class Builder(context: Context) : BaseDialog.Builder<Builder>(context) {

        init {
            setContentView(R.layout.copy_dialog)
            setAnimStyle(AnimAction.ANIM_BOTTOM)
            setGravity(Gravity.BOTTOM)
        }
    }
}
