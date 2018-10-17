package com.example.nguyenthanhtungh.moviedb.ui.favourite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.base.BaseRecyclerViewAdapter
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.databinding.MovieItemBinding

class FragmentFavouriteAdapter(val onItemClick: (Movie) -> Unit) : BaseRecyclerViewAdapter<Movie>(
        object : DiffUtil.ItemCallback<Movie>() {

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem?.title == newItem?.title
            }

            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem?.id == newItem?.id
            }
        }
) {
    override fun bindFirstTime(viewBinding: ViewDataBinding) {
        if (viewBinding is MovieItemBinding) viewBinding.movie?.let { onItemClick.invoke(it) }
    }

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item, parent, false
        )
    }

    override fun bind(binding: ViewDataBinding, item: Movie) {
        if (binding is MovieItemBinding) binding.movie = item
    }
}
