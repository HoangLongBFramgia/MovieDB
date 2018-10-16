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

    fun updateFavourite(movie: Movie) {
        if (isFavourite.value == false) {
            Observable.create<Unit> { emitter ->
                emitter.onNext(movieRepository.insertMoviesLocal(movie))
            }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        isFavourite.value = true
                    }, {
                        isFavourite.value = false
                    })
            return
        }
        if (isFavourite.value == true) {
            Observable.create<Unit> { emitter ->
                emitter.onNext(movieRepository.deleteMovieLocal(movie.id))
            }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        isFavourite.value = false
                    }, {
                        isFavourite.value = true
                    })
            return
        }
    }

    fun checkFavourite(movie: Movie) {
        movieRepository.getMovieLocal(movie.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isFavourite.value = true
                }, { isFavourite.value = false })
    }
}
