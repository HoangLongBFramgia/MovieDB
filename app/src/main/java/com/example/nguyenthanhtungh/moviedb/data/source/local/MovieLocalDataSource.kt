package com.example.nguyenthanhtungh.moviedb.data.source.local

import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.source.MovieDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.local.dao.MovieDao
import io.reactivex.Single

class MovieLocalDataSource(private val movieDao: MovieDao) : MovieDataSource.LocalDataSource {

    override fun insertMoviesLocal(movie: Movie) {
        movieDao.insert(movie)
    }

    override fun getMovieLocal(id: String): Single<Movie> {
        return movieDao.getMovie(id)
    }

    override fun deleteMovieLocal(id: String) {
        movieDao.deleteMovie(id)
    }

    override fun getListMoviesLocal(): Single<List<Movie>> {
        return movieDao.getMovieList()
    }

    override fun insertListMoviesLocal(list: List<Movie>) {
        return movieDao.insert(list)
    }

    override fun updateListMoviesLocal(movie: Movie) {
        return movieDao.update(movie)
    }
}
