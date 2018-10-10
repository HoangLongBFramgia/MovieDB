package com.example.nguyenthanhtungh.moviedb.di

import com.example.nguyenthanhtungh.moviedb.ui.main.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module(override = true) {
    viewModel { createMainViewModel() }
}

fun createMainViewModel() = MainViewModel()
