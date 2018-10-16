package com.example.nguyenthanhtungh.moviedb.ui.favourite

import androidx.databinding.library.baseAdapters.BR
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.base.BaseFragment
import com.example.nguyenthanhtungh.moviedb.databinding.FragmentFavouriteBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FavouriteFragment : BaseFragment<FragmentFavouriteBinding, FavouriteViewModel>() {

    companion object {
        const val TAG = "FavouriteFragment"
        fun newInstance() = FavouriteFragment()
    }

    override val bindingVariable: Int = BR.favouriteViewModel
    override val viewModel by viewModel<FavouriteViewModel>()
    override val layoutId: Int = R.layout.fragment_favourite

    override fun initComponent(viewDataBinding: FragmentFavouriteBinding) {

    }
}
