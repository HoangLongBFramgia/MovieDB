package com.example.nguyenthanhtungh.moviedb.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie(
        val vote_count: Int? = 0,
        val id: String? = null,
        val video: Boolean = false,
        val vote_average: Double = 0.0,
        val title: String? = null,
        val popularity: Double = 0.0,
        val poster_path: String? = null,
        val original_language: String? = null,
        val original_title: String? = null,
        val backdrop_path: String? = null,
        val adult: Boolean = false,
        val overview: String? = null,
        val release_date: String? = null,
        val belongs_to_collection: Boolean? = null,
        val budget: Int? = 0,
        val homepage: String? = null,
        val imdb_id: String? = null,
        val revenue: Int = 0,
        val runtime: Int = 0,
        val status: String? = null,
        val tagline: String? = null
) : Parcelable
