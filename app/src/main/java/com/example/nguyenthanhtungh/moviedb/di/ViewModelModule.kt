package com.example.nguyenthanhtungh.moviedb.di

import android.app.Application
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository
import com.example.nguyenthanhtungh.moviedb.ui.main.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module(override = true) {
    viewModel { createMainViewModel(get(), get(), get()) }
}

fun createMainViewModel(movieRepository: MovieRepository,
                        genreRepository: GenreRepository,
                        application: Application) = MainViewModel(movieRepository,
        genreRepository, application)
