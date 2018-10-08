package com.example.nguyenthanhtungh.moviedb.data.source.remote

import com.example.nguyenthanhtungh.moviedb.data.source.GenreDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.network.ApiService
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.GenreResponse
import io.reactivex.Single

class GenreRemoteDataSource(private val apiService: ApiService) : GenreDataSource.RemoteDataSource {
    override fun getListGenres(): Single<GenreResponse> {
        return apiService.getGenres()
    }
}
