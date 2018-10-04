package com.example.nguyenthanhtungh.moviedb.network

import com.example.nguyenthanhtungh.moviedb.BuildConfig
import com.example.nguyenthanhtungh.moviedb.model.Movie
import com.example.nguyenthanhtungh.moviedb.util.API_KEY_SYNTAX
import com.example.nguyenthanhtungh.moviedb.util.API_QUERY_SYNTAX
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("genre/list" + API_KEY_SYNTAX + BuildConfig.API_KEY)
    fun fetAllCategory(): Single<List<Movie>>

    @GET("search/movie" + API_KEY_SYNTAX + BuildConfig.API_KEY + API_QUERY_SYNTAX
            + "{movie}")
    fun searchMovie(@Path("movie") user: String): Single<List<Movie>>
}
