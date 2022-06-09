package com.ling.gateway.ui.adapter

import android.content.Context
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView
import com.ling.gateway.R
import com.ling.widget.adapter.AppAdapter

/**
 * author : wangchengzhen
 * github : https://github.com/getActivity/AndroidProject-Kotlin
 * time   : 2022/6/6
 * desc   : 图片预览适配器
 */
class ImagePreviewAdapter constructor(context: Context) : AppAdapter<String?>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder()
    }

    inner class ViewHolder : AppViewHolder(R.layout.image_preview_item) {

        private val photoView: PhotoView by lazy { getItemView() as PhotoView }

        override fun onBindView(position: Int) {
            Glide.with(getContext())
                .load(getItem(position))
                .into(photoView)
        }
    }
}
