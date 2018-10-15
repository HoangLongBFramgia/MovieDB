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
    var currentPage = MutableLiveData<Int>().apply { value = 0 }
    val isLoadMore = MutableLiveData<Boolean>()
    val listDiscoverMovie = MutableLiveData<List<Movie>>()

    private fun isFirst() = currentPage.value == 0
            && (listDiscoverMovie.value == null || listDiscoverMovie.value?.size == 0)

    fun firstLoad() {
        if (isFirst()) {
            isLoading.value = true
            loadListMovie(1)
        }
    }

    fun loadListMovie(page: Int) {
        addDisposable(
                movieRepository.getListDiscover(page)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe {
                            isLoading.value = true
                        }
                        .subscribe({
                            onLoadSuccess(page, it.listMovie)
                        }, {
                            onLoadFail(it)
                        }
                        )
        )
    }

    fun onLoadSuccess(page: Int, items: List<Movie>?) {
        currentPage.value = page
        val list = mutableListOf<Movie>()
        listDiscoverMovie.value?.let {
            list.addAll(it)
        }
        list.addAll(items ?: return)
        listDiscoverMovie.value = list
        isLoading.value = false
        isLoadMore.value = false
    }

    fun onLoadMore() {
        loadListMovie(currentPage.value?.plus(1) ?: 1)
    }

    override fun onLoadFail(throwable: Throwable) {
        super.onLoadFail(throwable)
        isLoadMore.value = false
    }
}
