package com.example.nguyenthanhtungh.moviedb.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie(
        @SerializedName("vote_count")
        val vote_count: Int? = 0,
        @SerializedName("id")
        val id: String? = null,
        @SerializedName("video")
        val video: Boolean? = false,
        @SerializedName("vote_average")
        val vote_average: Double? = 0.0,
        @SerializedName("title")
        val title: String? = null,
        @SerializedName("popularity")
        val popularity: Double? = 0.0,
        @SerializedName("poster_path")
        val poster_path: String? = null,
        @SerializedName("original_language")
        val original_language: String? = null,
        @SerializedName("original_title")
        val original_title: String? = null,
        @SerializedName("backdrop_path")
        val backdrop_path: String? = null,
        @SerializedName("adult")
        val adult: Boolean? = false,
        @SerializedName("overview")
        val overview: String? = null,
        @SerializedName("release_date")
        val release_date: String? = null
) : Parcelable
