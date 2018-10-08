package com.example.nguyenthanhtungh.moviedb.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nguyenthanhtungh.moviedb.data.model.Genre
import com.example.nguyenthanhtungh.moviedb.data.source.local.dao.GenreDao

@Database(entities = [Genre::class], version = 1, exportSchema = false)
abstract class GenreDatabase : RoomDatabase() {

    abstract fun genreDao(): GenreDao

    companion object {
        private lateinit var INSTANCE: GenreDatabase
        const val DB_NAME: String = "genre"

        open fun getGenreDatabase(context: Context): GenreDatabase {
            if (INSTANCE == null) {
                synchronized(GenreDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                GenreDatabase::class.java, DB_NAME)
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
