package com.example.nguyenthanhtungh.moviedb.di

import android.content.Context
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository
import com.example.nguyenthanhtungh.moviedb.data.source.GenreDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.MovieDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.local.GenreLocalDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.local.MovieLocalDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.local.dao.GenreDao
import com.example.nguyenthanhtungh.moviedb.data.source.local.dao.MovieDao
import com.example.nguyenthanhtungh.moviedb.data.source.local.db.AppDataBase
import com.example.nguyenthanhtungh.moviedb.data.source.remote.GenreRemoteDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.MovieRemoteDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.remote.network.ApiService
import org.koin.dsl.module.module

val repositoryModule = module(override = true) {
    single { createAppDatabase(get()) }
    single { createGenreDao(get()) }
    single { createMovieDao(get()) }
    single { createGenreLocalDataSource(get()) }
    single { createGenreRemoteDataSource(get()) }
    single { createMovieLocalDataSource(get()) }
    single { createMovieRemoteDataSource(get()) }
    single { createGenreRepository(get(), get()) }
    single { createMovieRepository(get(), get()) }
}

fun createAppDatabase(context: Context) = AppDataBase.getAppDatabase(context)

fun createGenreDao(appDatabase: AppDataBase) = appDatabase.genreDao()

fun createMovieDao(appDatabase: AppDataBase) = appDatabase.movieDao()

fun createGenreLocalDataSource(genreDao: GenreDao): GenreDataSource.LocalDataSource = GenreLocalDataSource(genreDao)

fun createGenreRemoteDataSource(apiService: ApiService): GenreDataSource.RemoteDataSource = GenreRemoteDataSource(apiService)

fun createMovieLocalDataSource(movieDao: MovieDao): MovieDataSource.LocalDataSource = MovieLocalDataSource(movieDao)

fun createMovieRemoteDataSource(apiService: ApiService): MovieDataSource.RemoteDataSource = MovieRemoteDataSource(apiService)

fun createGenreRepository(local: GenreDataSource.LocalDataSource,
                          remote: GenreDataSource.RemoteDataSource) = GenreRepository(local, remote)

fun createMovieRepository(local: MovieDataSource.LocalDataSource,
                          remote: MovieDataSource.RemoteDataSource) = MovieRepository(local, remote)
