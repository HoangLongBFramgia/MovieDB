package com.example.nguyenthanhtungh.moviedb.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movie")
class Movie(
        @PrimaryKey(autoGenerate = false)
        @SerializedName("id")
        var id: String,
        @SerializedName("vote_count")
        var vote_count: Int? = 0,
        @SerializedName("video")
        var video: Boolean? = false,
        @SerializedName("vote_average")
        var vote_average: Double? = 0.0,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("popularity")
        var popularity: Double? = 0.0,
        @SerializedName("poster_path")
        var poster_path: String? = null,
        @SerializedName("original_language")
        var original_language: String? = null,
        @SerializedName("original_title")
        var original_title: String? = null,
        @SerializedName("backdrop_path")
        var backdrop_path: String? = null,
        @SerializedName("adult")
        var adult: Boolean? = false,
        @SerializedName("overview")
        var overview: String? = null,
        @SerializedName("release_date")
        var release_date: String? = null,
        var is_favourite: Boolean? = false
) : Parcelable
