package com.example.nguyenthanhtungh.moviedb.data.source.remote.response

import com.example.nguyenthanhtungh.moviedb.data.model.Genre
import com.google.gson.annotations.SerializedName

class GenreResponse(
        @SerializedName("genres")
        var genres: List<Genre>
)
