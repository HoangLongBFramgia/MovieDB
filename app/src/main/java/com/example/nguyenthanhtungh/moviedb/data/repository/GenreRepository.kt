package com.example.nguyenthanhtungh.moviedb.data.repository

import com.example.nguyenthanhtungh.moviedb.data.source.GenreDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.local.GenreLocalDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.GenreRemoteDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.GenreResponse
import io.reactivex.Single

class GenreRepository(private val local: GenreLocalDataSource,
                      private val remote: GenreRemoteDataSource)
    : GenreDataSource.LocalDataSource, GenreDataSource.RemoteDataSource {

    override fun getListGenres(): Single<GenreResponse> {
        return remote.getListGenres()
    }
}
