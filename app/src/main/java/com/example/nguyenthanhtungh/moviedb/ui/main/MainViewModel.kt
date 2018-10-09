package com.example.nguyenthanhtungh.moviedb.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository

class MainViewModel constructor(private val movieRepository: MovieRepository,
                    private val genreRepository: GenreRepository,
                    application: Application) : AndroidViewModel(application) {

}
