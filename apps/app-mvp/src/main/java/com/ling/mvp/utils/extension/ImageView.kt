package com.ling.mvp.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * author : wangchengzhen
 * time   : 2022/7/12
 * desc   : ImageView
 */
internal fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .asBitmap()
        .load(url)
        .centerCrop()
        .into(this)
}
