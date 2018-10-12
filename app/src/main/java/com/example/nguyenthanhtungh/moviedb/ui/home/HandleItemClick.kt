package com.example.nguyenthanhtungh.moviedb.ui.home

import com.example.nguyenthanhtungh.moviedb.data.model.Movie

class HandleItemClick(var onItemMovieClick: OnItemMovieClick) {
    fun onMovieClick(movie: Movie) {
        onItemMovieClick.onClick(movie)
    }
}
