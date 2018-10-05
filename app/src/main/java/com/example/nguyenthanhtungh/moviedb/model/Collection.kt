package com.example.nguyenthanhtungh.moviedb.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Collection(
        @SerializedName("page")
        var page: String? = null,
        @SerializedName("total_results")
        var total_results: String? = null,
        @SerializedName("total_pages")
        var total_pages: String? = null,
        @SerializedName("results")
        var results: List<Movie>? = null
) : Parcelable
