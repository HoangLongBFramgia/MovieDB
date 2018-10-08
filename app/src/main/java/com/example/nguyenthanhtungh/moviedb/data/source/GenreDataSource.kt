package com.example.nguyenthanhtungh.moviedb.data.source

import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.GenreResponse
import io.reactivex.Single

interface GenreDataSource {
    interface LocalDataSource {
        //todo
    }

    interface RemoteDataSource {
        fun getListGenres(): Single<GenreResponse>
    }
}
