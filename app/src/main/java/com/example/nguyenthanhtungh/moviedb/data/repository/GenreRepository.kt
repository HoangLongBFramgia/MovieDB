package com.example.nguyenthanhtungh.moviedb.data.repository

import com.example.nguyenthanhtungh.moviedb.data.source.GenreDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.GenreResponse
import io.reactivex.Single

class GenreRepository(private val local: GenreDataSource.LocalDataSource,
                      private val remote: GenreDataSource.RemoteDataSource)
    : GenreDataSource.LocalDataSource, GenreDataSource.RemoteDataSource {

    override fun getListGenres(): Single<GenreResponse> {
        return remote.getListGenres()
    }
}
