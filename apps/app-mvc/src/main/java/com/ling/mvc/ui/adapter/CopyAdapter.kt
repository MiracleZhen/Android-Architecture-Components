package com.ling.mvc.ui.adapter

import android.content.Context
import android.view.ViewGroup
import com.ling.mvc.R
import com.ling.widget.adapter.AppAdapter

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/9
 * desc   : 可进行拷贝的副本
 */
class CopyAdapter constructor(context: Context) : AppAdapter<String?>(context) {

    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder()
    }

    inner class ViewHolder : AppViewHolder(R.layout.copy_item) {
        override fun onBindView(position: Int) {}
    }
}
