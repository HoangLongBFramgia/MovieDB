package com.example.nguyenthanhtungh.moviedb.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.nguyenthanhtungh.moviedb.base.BaseViewModel
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.data.repository.GenreRepository
import com.example.nguyenthanhtungh.moviedb.data.repository.MovieRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailViewModel(val genreRepository: GenreRepository,
                      val movieRepository: MovieRepository) : BaseViewModel() {
    val movie = MutableLiveData<Movie>()
    val isFavourite = MutableLiveData<Boolean>()
    val isFavouriteChange = MutableLiveData<Boolean>()

    fun updateFavourite(movie: Movie) {
        when (isFavourite.value) {
            false -> addDisposable(
                    Observable.create<Unit> { emitter ->
                        emitter.onNext(movieRepository.insertMoviesLocal(movie))
                    }
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                isFavourite.value = true
                                isFavouriteChange.value = isFavourite.value
                            }, {
                                isFavourite.value = false
                            }))

            true -> addDisposable(
                    Observable.create<Unit> { emitter ->
                        emitter.onNext(movieRepository.deleteMovieLocal(movie.id))
                    }
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({
                                isFavourite.value = false
                                isFavouriteChange.value = isFavourite.value
                            }, {
                                isFavourite.value = true
                            }))
        }
    }

    fun checkFavourite(movie: Movie) {
        addDisposable(
                movieRepository.getMovieLocal(movie.id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            isFavourite.value = true
                        }, { isFavourite.value = false }))
    }
}
