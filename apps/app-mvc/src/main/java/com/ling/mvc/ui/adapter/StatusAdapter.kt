package com.ling.mvc.ui.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.ling.mvc.R
import com.ling.widget.adapter.AppAdapter

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/4
 * desc   : 状态数据列表
 */
class StatusAdapter constructor(context: Context) : AppAdapter<String?>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        return ViewHolder()
    }

    inner class ViewHolder : AppViewHolder(R.layout.status_item) {

        private val textView: TextView? by lazy { findViewById(R.id.tv_status_text) }

        override fun onBindView(position: Int) {
            textView?.text = getItem(position)
        }
    }
}
