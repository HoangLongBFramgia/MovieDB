package com.example.nguyenthanhtungh.moviedb.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie(
        @SerializedName("vote_count")
        @Expose
        val voteCount: Int? = 0,
        @SerializedName("id")
        @Expose
        val id: String,
        @SerializedName("video")
        @Expose
        val video: Boolean = false,
        @SerializedName("vote_average")
        @Expose
        val voteAverage: Double = 0.0,
        @SerializedName("title")
        @Expose
        val title: String? = null,
        @SerializedName("popularity")
        @Expose
        val popularity: Double = 0.0,
        @SerializedName("poster_path")
        @Expose
        val posterPath: String? = null,
        @SerializedName("original_language")
        @Expose
        val originalLanguage: String? = null,
        @SerializedName("original_title")
        @Expose
        val originalTitle: String? = null,
        @SerializedName("backdrop_path")
        @Expose
        val backdropPath: String? = null,
        @SerializedName("adult")
        @Expose
        val adult: Boolean = false,
        @SerializedName("overview")
        @Expose
        val overview: String? = null,
        @SerializedName("release_date")
        @Expose
        val releaseDate: String? = null,
        @SerializedName("belongs_to_collection")
        @Expose
        val belongsToCollection: Boolean? = null,
        @SerializedName("budget")
        @Expose
        val budget: Int? = 0,
        @SerializedName("homepage")
        @Expose
        val homepage: String? = null,
        @SerializedName("imdb_id")
        @Expose
        val imdbId: String? = null,
        @SerializedName("revenue")
        @Expose
        val revenue: Int = 0,
        @SerializedName("runtime")
        @Expose
        val runtime: Int = 0,
        @SerializedName("status")
        @Expose
        val status: String? = null,
        @SerializedName("tagline")
        @Expose
        val tagLine: String? = null
) : Parcelable

