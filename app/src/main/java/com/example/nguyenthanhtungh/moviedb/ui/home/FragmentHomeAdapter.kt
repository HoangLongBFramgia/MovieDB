package com.example.nguyenthanhtungh.moviedb.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.databinding.MovieItemBinding

class FragmentHomeAdapter(var listener: OnItemMovieClick, var listMovies: List<Movie>)
    : RecyclerView.Adapter<FragmentHomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemBinding: MovieItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item,
                parent, false)
        itemBinding.click = HandleItemClick(listener)
        return HomeViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {

        return listMovies.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        holder.bindData(listMovies[position])
    }

    class HomeViewHolder(var itemBinding: MovieItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {

        fun bindData(movie: Movie) {
            itemBinding.movie = movie
        }
    }
}
