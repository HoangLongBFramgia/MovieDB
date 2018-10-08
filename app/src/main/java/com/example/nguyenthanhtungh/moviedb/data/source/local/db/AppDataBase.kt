package com.example.nguyenthanhtungh.moviedb.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nguyenthanhtungh.moviedb.data.model.Genre
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.source.local.dao.GenreDao
import com.example.nguyenthanhtungh.moviedb.data.source.local.dao.MovieDao

@Database(entities = [Movie::class, Genre::class], version = 1, exportSchema = false)

abstract class AppDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun genreDao(): GenreDao

    companion object {
        private lateinit var INSTANCE: AppDataBase
        const val DB_NAME: String = "movie_db"

        open fun getAppDatabase(context: Context): AppDataBase {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDataBase::class.java, DB_NAME)
                            .build()
                }
            }
            return INSTANCE
        }
    }
}
