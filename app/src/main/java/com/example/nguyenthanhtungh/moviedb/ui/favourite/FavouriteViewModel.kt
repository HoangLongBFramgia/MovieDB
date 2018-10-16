package com.example.nguyenthanhtungh.moviedb.ui.favourite

import androidx.lifecycle.MutableLiveData
import com.example.nguyenthanhtungh.moviedb.base.BaseViewModel
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository

class FavouriteViewModel(val genreRepository: GenreRepository,
                         val movieRepository: MovieRepository) : BaseViewModel() {
    val isLoading = MutableLiveData<Boolean>()
}
