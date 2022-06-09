package com.ling.mvc.ui.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import com.ling.mvc.R
import com.ling.widget.adapter.AppAdapter

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/6
 * desc   : 引导页适配器
 */
class GuideAdapter constructor(context: Context) : AppAdapter<Int>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder()
    }

    inner class ViewHolder : AppViewHolder(R.layout.guide_item) {

        private val imageView: ImageView by lazy { getItemView() as ImageView }

        override fun onBindView(position: Int) {
            imageView.setImageResource(getItem(position))
        }
    }
}
