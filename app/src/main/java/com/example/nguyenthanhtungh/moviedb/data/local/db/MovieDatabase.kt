package com.example.nguyenthanhtungh.moviedb.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.nguyenthanhtungh.moviedb.data.local.dao.MovieDao
import com.example.nguyenthanhtungh.moviedb.data.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
