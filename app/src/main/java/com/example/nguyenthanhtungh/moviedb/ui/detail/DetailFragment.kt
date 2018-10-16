package com.example.nguyenthanhtungh.moviedb.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.nguyenthanhtungh.moviedb.BR
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.base.BaseFragment
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.databinding.FragmentMovieDetailBinding
import com.example.nguyenthanhtungh.moviedb.ui.main.MainActivity
import org.koin.android.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentMovieDetailBinding, DetailViewModel>() {

    companion object {
        const val MOVIE = "MOVIE"
        const val TAG = "DetailFragment"
        fun newInstance(movie: Movie) = DetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MOVIE, movie)
            }
        }
    }

    override val bindingVariable: Int = BR.detailViewModel

    override val viewModel by viewModel<DetailViewModel>()

    override val layoutId: Int = R.layout.fragment_movie_detail

    override fun initComponent(viewDataBinding: FragmentMovieDetailBinding) {
        val movie = arguments?.getParcelable<Movie>(MOVIE) ?: return

        arguments?.apply {
            getParcelable<Movie>(MOVIE)?.apply {
                viewModel.movie.value = this
            }
        }

        viewDataBinding.onBackClick = View.OnClickListener {
            if (activity is MainActivity) {
                (activity as MainActivity).apply {
                    onBackPressed()
                }
            }
        }

        viewDataBinding.onFavouriteClick = View.OnClickListener {
            viewModel.updateFavourite(movie)
            if (viewModel.isFavourite.value == true) {
                Toast.makeText(context, getString(R.string.remove_favourite), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, getString(R.string.add_favourite), Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.apply {
            checkFavourite(movie)
        }
    }
}
