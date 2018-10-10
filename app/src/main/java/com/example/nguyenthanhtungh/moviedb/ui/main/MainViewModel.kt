package com.example.nguyenthanhtungh.moviedb.ui.main

import androidx.lifecycle.ViewModel
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository

class MainViewModel constructor(private val movieRepository: MovieRepository,
                                private val genreRepository: GenreRepository) : ViewModel() {

}
