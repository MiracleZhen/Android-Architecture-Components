package com.ling.gateway.ui.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ling.gateway.R
import com.ling.widget.adapter.AppAdapter

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/6
 * desc   : 图片选择适配器
 */
class ImageSelectAdapter constructor(context: Context, private val mSelectImages: MutableList<String>) : AppAdapter<String>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        return ViewHolder()
    }

    inner class ViewHolder : AppViewHolder(R.layout.image_select_item) {

        private val imageView: ImageView? by lazy { findViewById(R.id.iv_image_select_image) }
        private val checkBox: CheckBox? by lazy { findViewById(R.id.cb_image_select_check) }

        override fun onBindView(position: Int) {
            getItem(position).apply {
                imageView?.let {
                    Glide.with(getContext())
                        .asBitmap()
                        .load(this)
                        .into(it)
                }
                checkBox?.isChecked = mSelectImages.contains(this)
            }
        }
    }

    override fun generateDefaultLayoutManager(context: Context): RecyclerView.LayoutManager {
        return GridLayoutManager(context, 3)
    }
}
