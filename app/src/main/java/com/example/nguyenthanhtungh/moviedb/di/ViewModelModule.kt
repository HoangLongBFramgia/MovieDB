package com.example.nguyenthanhtungh.moviedb.di

import android.app.Application
import com.example.nguyenthanhtungh.moviedb.ui.favourite.DetailViewModel
import com.example.nguyenthanhtungh.moviedb.ui.favourite.FavouriteViewModel
import com.example.nguyenthanhtungh.moviedb.ui.home.HomeViewModel
import com.example.nguyenthanhtungh.moviedb.ui.main.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module(override = true) {
    viewModel { createMainViewModel() }
    viewModel { createHomeViewModel() }
    viewModel { createFavouriteViewModel() }
    viewModel { createDetailViewModel() }
}

fun createMainViewModel() = MainViewModel()
fun createHomeViewModel() = HomeViewModel()
fun createFavouriteViewModel() = FavouriteViewModel()
fun createDetailViewModel() = DetailViewModel()
