package com.example.nguyenthanhtungh.moviedb.data.source.local.dao

import androidx.room.*
import com.example.nguyenthanhtungh.moviedb.data.model.Genre
import io.reactivex.Maybe

@Dao
interface GenreDao {
    @Query("SELECT * FROM genre")
    fun getGenreList(): Maybe<List<Genre>>

    @Query("SELECT * FROM genre WHERE genre.id = :id")
    fun getGenre(id: String): Maybe<Genre>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(genre: Genre)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(list: List<Genre>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(genre: Genre)

    @Delete
    fun deleteGenre(genre: Genre)

    @Query("DELETE FROM genre WHERE id = :id")
    fun deleteGenre(id: String)

    @Query("DELETE FROM genre")
    fun deleteAll()
}
