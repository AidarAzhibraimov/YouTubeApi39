package com.kg.geektech.youtubeapi39.core.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImg(url: String) {
    Glide.with(this)
        .load(url)
        .into(this)
}