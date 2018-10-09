package com.example.nguyenthanhtungh.moviedb.data.repository

import com.example.nguyenthanhtungh.moviedb.data.model.Genre
import com.example.nguyenthanhtungh.moviedb.data.source.GenreDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.GenreResponse
import io.reactivex.Single

class GenreRepository(private val local: GenreDataSource.LocalDataSource,
                      private val remote: GenreDataSource.RemoteDataSource)
    : GenreDataSource.LocalDataSource, GenreDataSource.RemoteDataSource {

    override fun deleteGenreLocal(id: String) = local.deleteGenreLocal(id)

    override fun getListGenresLocal(): Single<List<Genre>> = local.getListGenresLocal()

    override fun insertListGenresLocal(list: List<Genre>) = local.insertListGenresLocal(list)

    override fun updateListGenresLocal(genre: Genre) = local.updateListGenresLocal(genre)

    override fun getListGenres(): Single<GenreResponse> = remote.getListGenres()
}
