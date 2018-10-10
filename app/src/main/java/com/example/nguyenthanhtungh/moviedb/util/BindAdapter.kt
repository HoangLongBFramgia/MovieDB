package com.example.nguyenthanhtungh.moviedb.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindAdapter {
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, image: String) {
        Glide.with(imageView.context).load(image).into(imageView)
    }
}