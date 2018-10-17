package com.example.nguyenthanhtungh.moviedb.ui.search

import androidx.lifecycle.MutableLiveData
import com.example.nguyenthanhtungh.moviedb.base.BaseViewModel
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchViewModel(val genreRepository: GenreRepository,
                      val movieRepository: MovieRepository) : BaseViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val isLoadMore = MutableLiveData<Boolean>()
    val queryString = MutableLiveData<String>()
    val loadError = MutableLiveData<String>()
    val listSearch = MutableLiveData<List<Movie>>()
    var currentPage = 0

    fun getListSearch(query: String, page: Int) {
        addDisposable(
                movieRepository.searchMovie(query, page)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doFinally {
                            isLoading.value = false
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

    fun firstLoad(query: String) {
        isLoading.value = true
        getListSearch(query, 1)
    }

    fun onLoadMore(query: String) {
        isLoadMore.value = true
        getListSearch(query, currentPage + 1)
    }

    private fun onLoadSuccess(page: Int, items: List<Movie>?) {
        currentPage = page

        if (isLoading.value == true) {
            listSearch.value = items
            return
        }

        if (isLoadMore.value == true) {
            val list = mutableListOf<Movie>()
            listSearch.value?.let {
                list.addAll(it)
            }
            list.addAll(items ?: return)
            listSearch.value = list
            return
        }
    }

    private fun onLoadFail(throwable: Throwable) {
        isLoading.value = false
        isLoadMore.value = false
        loadError.value = throwable.message
    }
}
