package com.example.nguyenthanhtungh.moviedb.data.source

import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.CollectionResponse
import io.reactivex.Single

interface MovieDataSource {
    interface LocalDataSource {
        fun getListMoviesLocal(): Single<List<Movie>>
        fun getMovieLocal(id: String) : Single<Movie>
        fun insertListMoviesLocal(list: List<Movie>)
        fun insertMoviesLocal(movie: Movie)
        fun updateListMoviesLocal(movie: Movie)
        fun deleteMovieLocal(id: String)
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
