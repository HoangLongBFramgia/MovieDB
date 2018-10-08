package com.example.nguyenthanhtungh.moviedb.data.source.remote.network

import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.CollectionResponse
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.GenreResponse
import com.example.nguyenthanhtungh.moviedb.util.API_QUERY_PARAM
import com.example.nguyenthanhtungh.moviedb.util.PARAM_PAGE
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getListPopular(@Query(PARAM_PAGE) page: Int): Single<CollectionResponse>

    @GET("movie/top_rate")
    fun getListTopRate(@Query(PARAM_PAGE) page: Int): Single<CollectionResponse>

    @GET("movie/now_playing")
    fun getListNowPlaying(@Query(PARAM_PAGE) page: Int): Single<CollectionResponse>

    @GET("movie/upcoming")
    fun getListUpComing(@Query(PARAM_PAGE) page: Int): Single<CollectionResponse>

    @GET("discover/movie")
    fun getListDiscoverMovie(@Query(PARAM_PAGE) page: Int): Single<CollectionResponse>

    @GET("search/movie")
    fun searchMovie(@Query(API_QUERY_PARAM) title: String,
                    @Query(PARAM_PAGE) page: Int): Single<CollectionResponse>

    @GET("genre/movie/list")
    fun getGenres(): Single<GenreResponse>
}
