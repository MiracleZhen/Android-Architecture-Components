package com.ling.widget.dialog

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.annotation.StringRes
import com.ling.base.BaseDialog
import com.ling.widget.R

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/3
 * desc   : 消息对话框
 */
class MessageDialog {

    class Builder constructor(context: Context) : CommonDialog.Builder<Builder>(context) {

        private val messageView: TextView? by lazy { findViewById(R.id.tv_message_message) }

        private var listener: OnListener? = null

        init {
            setCustomView(R.layout.widget_dialog_message)
        }

        fun setMessage(@StringRes id: Int): Builder = apply {
            setMessage(getString(id))
        }

        fun setMessage(text: CharSequence?): Builder = apply {
            messageView?.text = text
        }

        fun setListener(listener: OnListener?): Builder = apply {
            this.listener = listener
        }

        override fun create(): BaseDialog {
            // 如果内容为空就抛出异常
            if (("" == messageView?.text.toString())) {
                throw IllegalArgumentException("Dialog message not null")
            }
            return super.create()
        }

        override fun onClick(view: View) {
            when (view.id) {
                R.id.tv_ui_confirm -> {
                    autoDismiss()
                    listener?.onConfirm(getDialog())
                }
                R.id.tv_ui_cancel -> {
                    autoDismiss()
                    listener?.onCancel(getDialog())
                }
            }
        }
    }

    interface OnListener {

        /**
         * 点击确定时回调
         */
        fun onConfirm(dialog: BaseDialog?)

        /**
         * 点击取消时回调
         */
        fun onCancel(dialog: BaseDialog?) {}
    }
}
