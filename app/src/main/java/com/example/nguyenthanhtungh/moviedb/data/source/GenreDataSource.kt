package com.example.nguyenthanhtungh.moviedb.data.source

import com.example.nguyenthanhtungh.moviedb.data.model.Genre
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.GenreResponse
import io.reactivex.Single

interface GenreDataSource {
    interface LocalDataSource {
        fun getListGenresLocal(): Single<List<Genre>>
        fun insertListGenresLocal(list: List<Genre>)
        fun updateListGenresLocal(genre: Genre)
        fun deleteGenreLocal(id: String)
    }

    interface RemoteDataSource {
        fun getListGenres(): Single<GenreResponse>
    }
}
