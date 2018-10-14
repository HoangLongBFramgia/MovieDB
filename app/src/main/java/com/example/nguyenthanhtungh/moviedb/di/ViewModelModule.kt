package com.example.nguyenthanhtungh.moviedb.di

import com.example.nguyenthanhtungh.moviedb.ui.favourite.DetailViewModel
import com.example.nguyenthanhtungh.moviedb.ui.favourite.FavouriteViewModel
import com.example.nguyenthanhtungh.moviedb.ui.favourite.SearchViewModel
import com.example.nguyenthanhtungh.moviedb.ui.home.HomeViewModel
import com.example.nguyenthanhtungh.moviedb.ui.main.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module(override = true) {
    viewModel { MainViewModel() }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { FavouriteViewModel() }
    viewModel { DetailViewModel() }
    viewModel { SearchViewModel() }
}
