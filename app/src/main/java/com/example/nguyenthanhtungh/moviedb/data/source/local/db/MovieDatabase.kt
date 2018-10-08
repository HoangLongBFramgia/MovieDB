package com.example.nguyenthanhtungh.moviedb.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nguyenthanhtungh.moviedb.data.source.local.dao.MovieDao
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import androidx.room.Room


@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private lateinit var INSTANCE: MovieDatabase
        const val DB_NAME: String = "movie"

        open fun getMovieDatabase(context: Context): MovieDatabase {
            if (INSTANCE == null) {
                synchronized(MovieDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                MovieDatabase::class.java, DB_NAME)
                                .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
