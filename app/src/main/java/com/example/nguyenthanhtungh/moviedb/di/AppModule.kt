package com.example.nguyenthanhtungh.moviedb.di

import android.content.res.Resources
import com.example.nguyenthanhtungh.moviedb.MyApplication
import org.koin.dsl.module.module

val appModule = module(override = true) {
    single { createResources(get()) }
}

fun createResources(application: MyApplication): Resources = application.resources
