package com.slee.country.util

import android.widget.ImageView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest

// https://github.com/coil-kt/coil/tree/master/coil-svg to show svg
fun ImageView.loadSvg(imageUrl: String) {
    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
        .build()

    val request = ImageRequest.Builder(this.context)
        .crossfade(true)
        .crossfade(500)
        .data(imageUrl)
        .target(this)
        .build()

    imageLoader.enqueue(request)
}