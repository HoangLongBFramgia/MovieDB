package com.example.nguyenthanhtungh.moviedb.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.nguyenthanhtungh.moviedb.base.BaseViewModel
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository

class DetailViewModel(val genreRepository: GenreRepository,
                      val movieRepository: MovieRepository) : BaseViewModel() {
    val movie = MutableLiveData<Movie>()
    val isFavourite = MutableLiveData<Boolean>().apply { value = false }
}
