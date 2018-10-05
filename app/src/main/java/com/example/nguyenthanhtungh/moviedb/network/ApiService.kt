package com.example.nguyenthanhtungh.moviedb.network

import com.example.nguyenthanhtungh.moviedb.model.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("discover/movie")
    fun getListMovie(): Single<List<Movie>>

    @GET("search/movie" + "{movie}")
    fun searchMovie(@Path("movie") movie: String): Single<List<Movie>>
}
