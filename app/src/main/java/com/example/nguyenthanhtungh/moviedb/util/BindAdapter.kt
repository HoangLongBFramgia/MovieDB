package com.example.nguyenthanhtungh.moviedb.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.nguyenthanhtungh.moviedb.R

object BindAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, image: String?) {
        Glide.with(imageView.context)
                .load(BASE_IMAGE_URL + image)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_launcher_background)
                        .diskCacheStrategy(DiskCacheStrategy.DATA))
                .into(imageView)
    }
}
