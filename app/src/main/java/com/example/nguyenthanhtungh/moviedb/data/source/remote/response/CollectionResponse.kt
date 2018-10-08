package com.example.nguyenthanhtungh.moviedb.data.source.remote.response

import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.google.gson.annotations.SerializedName

class CollectionResponse(
        @SerializedName("page")
        var page: Int = 0,
        @SerializedName("total_results")
        var totalResult: Int = 0,
        @SerializedName("total_pages")
        var totalPage: Int = 0,
        @SerializedName("results")
        var listMovie: List<Movie>
)
