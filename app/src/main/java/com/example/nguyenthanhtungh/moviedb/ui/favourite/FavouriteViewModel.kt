package com.example.nguyenthanhtungh.moviedb.ui.favourite

import androidx.lifecycle.MutableLiveData
import com.example.nguyenthanhtungh.moviedb.base.BaseViewModel
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FavouriteViewModel(val genreRepository: GenreRepository,
                         val movieRepository: MovieRepository) : BaseViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val isRefresh = MutableLiveData<Boolean>()
    val listFavouriteMovie = MutableLiveData<List<Movie>>()
    val loadError = MutableLiveData<String>()

    fun getData() {
        addDisposable(
                movieRepository.getListMoviesLocal()
                        .subscribeOn(Schedulers.io())
                        .doOnSubscribe { isLoading.value = true }
                        .observeOn(AndroidSchedulers.mainThread())
                        .doAfterTerminate {
                            isRefresh.value = false
                            isLoading.value = false
                        }
                        .subscribe(
                                {
                                    loadSuccess(it)
                                },
                                {
                                    loadFail(it)
                                }
                        )
        )
    }

    fun refresh() {
        isRefresh.value = true
        getData()
    }

    private fun loadSuccess(movies: List<Movie>) {
        listFavouriteMovie.value = movies
    }

    private fun loadFail(throwable: Throwable) {
        loadError.value = throwable.message
    }
}
