package com.example.nguyenthanhtungh.moviedb.data.source

import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.CollectionResponse
import io.reactivex.Single

interface MovieDataSource {
    interface LocalDataSource {
        //todo
    }

    interface RemoteDataSource {
        fun getListNowPlaying(page: Int): Single<CollectionResponse>
        fun getListPopular(page: Int): Single<CollectionResponse>
        fun getListTopRate(page: Int): Single<CollectionResponse>
        fun getListUpComing(page: Int): Single<CollectionResponse>
        fun getListDiscover(page: Int): Single<CollectionResponse>
        fun searchMovie(query: String, page: Int): Single<CollectionResponse>
    }
}
