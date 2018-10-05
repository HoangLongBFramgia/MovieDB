package com.example.nguyenthanhtungh.moviedb.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import io.reactivex.Maybe

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getMovieList(): Maybe<List<Movie>>

    @Query("SELECT * FROM movie WHERE movie.id = :id")
    fun getMovie(id: String): Maybe<Movie>

    @Insert(onConflict = IGNORE)
    fun insert(movie: Movie)

    @Insert(onConflict = IGNORE)
    fun insert(list: List<Movie>)

    @Insert(onConflict = REPLACE)
    fun update(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)

    @Query("DELETE FROM movie WHERE id = :id")
    fun deleteMovie(id: String)

    @Query("DELETE FROM movie")
    fun deleteAll()
}