package com.example.nguyenthanhtungh.moviedb.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.nguyenthanhtungh.moviedb.base.BaseViewModel
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(val genreRepository: GenreRepository,
                    val movieRepository: MovieRepository) : BaseViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val isRefresh = MutableLiveData<Boolean>()
    val isLoadMore = MutableLiveData<Boolean>()
    //
    val loadError = MutableLiveData<String>()
    val listDiscoverMovie = MutableLiveData<List<Movie>>()
    var currentPage = MutableLiveData<Int>().apply { value = 0 }

    fun loadListMovie(page: Int) {
        addDisposable(
                movieRepository.getListDiscover(page)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doFinally {
                            isLoading.value = false
                            isRefresh.value = false
                            isLoadMore.value = false
                        }
                        .subscribe({
                            onLoadSuccess(page, it.listMovie)
                        }, {
                            onLoadFail(it)
                        }
                        )
        )
    }

    fun firstLoad() {
        isLoading.value = true
        loadListMovie(1)
    }

    fun refreshData() {
        isRefresh.value = true
        loadListMovie(1)
    }

    fun onLoadMore() {
        isLoadMore.value = true
        loadListMovie(currentPage.value?.plus(1) ?: 1)
    }

    private fun onLoadSuccess(page: Int, items: List<Movie>?) {
        currentPage.value = page

        if (isRefresh.value == true || isLoading.value == true) {
            listDiscoverMovie.value = items
            return
        }

        if (isLoadMore.value == true) {
            val list = mutableListOf<Movie>()
            listDiscoverMovie.value?.let {
                list.addAll(it)
            }
            list.addAll(items ?: return)
            listDiscoverMovie.value = list
            return
        }
    }

    private fun onLoadFail(throwable: Throwable) {
        isLoading.value = false
        isLoadMore.value = false
        isLoading.value = false
        isRefresh.value = false
        loadError.value = throwable.toString()
    }
}
