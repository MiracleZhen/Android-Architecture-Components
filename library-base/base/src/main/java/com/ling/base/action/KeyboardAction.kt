package com.ling.base.action

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 *    @author : wangchengzhen
 *    @time   : 2022/5/16
 *    @desc   : 软键盘相关意图
 */
interface KeyboardAction {

    /**
     * 显示软键盘，需要先 requestFocus 获取焦点，如果是在 Activity Create，那么需要延迟一段时间
     */
    fun showKeyboard(view: View?) {
        view?.let {
            val manager: InputMethodManager = it.context
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager? ?: return
            manager.showSoftInput(it, InputMethodManager.SHOW_FORCED)
        }
    }

    /**
     * 隐藏软键盘
     */
    fun hideKeyboard(view: View?) {
        view?.let {
            val manager: InputMethodManager = it.context
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager? ?: return
            manager.hideSoftInputFromWindow(it.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    /**
     * 切换软键盘
     */
    fun toggleSoftInput(view: View?) {
        view?.let {
            val manager: InputMethodManager = it.context
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager? ?: return
            manager.toggleSoftInput(0, 0)
        }
    }
}
