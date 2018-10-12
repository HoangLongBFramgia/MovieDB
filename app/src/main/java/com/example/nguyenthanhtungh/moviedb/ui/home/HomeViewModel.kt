package com.example.nguyenthanhtungh.moviedb.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.nguyenthanhtungh.moviedb.base.BaseViewModel
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val compositeDisposable: CompositeDisposable,
                    private val genreRepository: GenreRepository,
                    private val movieRepository: MovieRepository) : BaseViewModel() {

    val listDiscover = MutableLiveData<List<Movie>>()

    fun getListDiscoverMovie() {
        compositeDisposable.apply {
            add(movieRepository.getListDiscover(1)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { items ->
                        listDiscover.value = items.listMovie
                    }
            )
        }
    }
}
