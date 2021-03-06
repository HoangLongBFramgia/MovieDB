package com.example.nguyenthanhtungh.moviedb.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import io.reactivex.Single

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getMovieList(): Single<List<Movie>>

    @Query("SELECT * FROM movie WHERE movie.id = :id")
    fun getMovie(id: String): Single<Movie>

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
