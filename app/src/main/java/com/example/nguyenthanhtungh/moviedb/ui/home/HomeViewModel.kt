package com.example.nguyenthanhtungh.moviedb.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.nguyenthanhtungh.moviedb.base.BaseViewModel
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val genreRepository: GenreRepository,
                    private val movieRepository: MovieRepository) : BaseViewModel() {
    val isLoading = MutableLiveData<Boolean>().apply { value = true }
    val listDiscover = MutableLiveData<List<Movie>>()

    fun getListDiscoverMovie() {
        movieRepository.getListDiscover(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { isLoading.value = false }
                .subscribe { items ->
                    listDiscover.value = items.listMovie
                }
    }
}
