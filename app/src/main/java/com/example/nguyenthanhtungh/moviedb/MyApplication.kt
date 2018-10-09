package com.example.nguyenthanhtungh.moviedb

import android.app.Application
import com.example.nguyenthanhtungh.moviedb.di.apiModule
import com.example.nguyenthanhtungh.moviedb.di.appModule
import com.example.nguyenthanhtungh.moviedb.di.repositoryModule
import com.example.nguyenthanhtungh.moviedb.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                appModule,
                apiModule,
                repositoryModule,
                viewModelModule
        ))
    }
}
