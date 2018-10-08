package com.example.nguyenthanhtungh.moviedb.data.repository

import com.example.nguyenthanhtungh.moviedb.data.source.MovieDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.local.MovieLocalDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.MovieRemoteDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.CollectionResponse
import io.reactivex.Single

class MovieRepository(private val local: MovieLocalDataSource,
                      private val remote: MovieRemoteDataSource)
    : MovieDataSource.LocalDataSource, MovieDataSource.RemoteDataSource {
    override fun getListNowPlaying(page: Int): Single<CollectionResponse> {
        return remote.getListNowPlaying(page)
    }

    override fun getListPopular(page: Int): Single<CollectionResponse> {
        return remote.getListPopular(page)
    }

    override fun getListTopRate(page: Int): Single<CollectionResponse> {
        return remote.getListTopRate(page)
    }

    override fun getListUpComing(page: Int): Single<CollectionResponse> {
        return remote.getListUpComing(page)
    }

    override fun getListDiscover(page: Int): Single<CollectionResponse> {
        return remote.getListDiscover(page)
    }

    override fun searchMovie(query: String, page: Int): Single<CollectionResponse> {
        return remote.searchMovie(query, page)
    }

}
