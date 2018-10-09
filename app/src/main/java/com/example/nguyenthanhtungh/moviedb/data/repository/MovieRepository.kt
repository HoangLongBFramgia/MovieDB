package com.example.nguyenthanhtungh.moviedb.data.repository

import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.source.MovieDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.response.CollectionResponse
import io.reactivex.Single

class MovieRepository(private val local: MovieDataSource.LocalDataSource,
                      private val remote: MovieDataSource.RemoteDataSource)
    : MovieDataSource.LocalDataSource, MovieDataSource.RemoteDataSource {

    override fun deleteMovieLocal(id: String)
            = local.deleteMovieLocal(id)

    override fun getListMoviesLocal(): Single<List<Movie>>
            = local.getListMoviesLocal()

    override fun insertListMoviesLocal(list: List<Movie>)
            = local.insertListMoviesLocal(list)

    override fun updateListMoviesLocal(movie: Movie)
            = local.updateListMoviesLocal(movie)

    override fun getListNowPlaying(page: Int): Single<CollectionResponse>
            = remote.getListNowPlaying(page)

    override fun getListPopular(page: Int): Single<CollectionResponse>
            = remote.getListPopular(page)

    override fun getListTopRate(page: Int): Single<CollectionResponse>
            = remote.getListTopRate(page)

    override fun getListUpComing(page: Int): Single<CollectionResponse>
            = remote.getListUpComing(page)

    override fun getListDiscover(page: Int): Single<CollectionResponse>
            = remote.getListDiscover(page)

    override fun searchMovie(query: String, page: Int): Single<CollectionResponse>
            = remote.searchMovie(query, page)
}
