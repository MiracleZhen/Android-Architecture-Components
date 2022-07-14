package com.ling.mvp.utils

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import androidx.core.graphics.drawable.toDrawable
import com.ling.mvp.R

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : CommonUtils
 */
object CommonUtils {

    fun showLoadingDialog(context: Context?): ProgressDialog {
        return ProgressDialog(context).apply {
            this.show()
            this.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            this.setContentView(R.layout.progress_dialog)
            this.isIndeterminate = true
            this.setCancelable(false)
            this.setCanceledOnTouchOutside(false)
        }
    }
}
