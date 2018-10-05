package com.example.nguyenthanhtungh.moviedb.network

import com.example.nguyenthanhtungh.moviedb.model.ListMovies
import com.example.nguyenthanhtungh.moviedb.model.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("discover/movie")
    fun getListMovie(): Single<ListMovies>

    @GET("search/movie" + "{movie}")
    fun searchMovie(@Path("movie") movie: String): Single<List<Movie>>
}
