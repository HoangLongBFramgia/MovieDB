package com.example.nguyenthanhtungh.moviedb.data.source.remote

import com.example.nguyenthanhtungh.moviedb.data.source.MovieDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.network.ApiService
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.CollectionResponse
import io.reactivex.Single

class MovieRemoteDataSource(private val apiService: ApiService) : MovieDataSource.RemoteDataSource {
    override fun getListNowPlaying(page: Int): Single<CollectionResponse> {
        return apiService.getListNowPlaying(page)
    }

    override fun getListPopular(page: Int): Single<CollectionResponse> {
        return apiService.getListPopular(page)
    }

    override fun getListTopRate(page: Int): Single<CollectionResponse> {
        return apiService.getListTopRate(page)
    }

    override fun getListUpComing(page: Int): Single<CollectionResponse> {
        return apiService.getListUpComing(page)
    }

    override fun getListDiscover(page: Int): Single<CollectionResponse> {
        return apiService.getListDiscoverMovie(page)
    }

    override fun searchMovie(query: String, page: Int): Single<CollectionResponse> {
        return apiService.searchMovie(query, page)
    }
}
