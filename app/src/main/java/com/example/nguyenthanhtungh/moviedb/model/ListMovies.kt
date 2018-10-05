package com.example.nguyenthanhtungh.moviedb.model

import com.google.gson.annotations.SerializedName

class ListMovies(@SerializedName("results") var movies: List<Movie>)