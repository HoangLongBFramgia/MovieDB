package com.example.nguyenthanhtungh.moviedb.data.remote

import com.example.nguyenthanhtungh.moviedb.data.model.Collection
import com.example.nguyenthanhtungh.moviedb.util.API_QUERY_PARAM
import com.example.nguyenthanhtungh.moviedb.util.PARAM_PAGE
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getListPopular(@Query(PARAM_PAGE) page: Int): Single<Collection>

    @GET("movie/top_rate")
    fun getListTopRate(@Query(PARAM_PAGE) page: Int): Single<Collection>

    @GET("movie/now_playing")
    fun getListNowPlaying(@Query(PARAM_PAGE) page: Int): Single<Collection>

    @GET("movie/upcoming")
    fun getListUpComing(@Query(PARAM_PAGE) page: Int): Single<Collection>

    @GET("discover/movie")
    fun getListMovie(@Query(PARAM_PAGE) page: Int): Single<Collection>

    @GET("search/movie")
    fun searchMovie(@Query(API_QUERY_PARAM) title: String,
                    @Query(PARAM_PAGE) page: Int): Single<Collection>
}
