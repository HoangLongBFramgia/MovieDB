package com.example.nguyenthanhtungh.moviedb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.base.RecyclerItemDecoration
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.databinding.FragmentHomeBinding
import com.example.nguyenthanhtungh.moviedb.ui.favourite.DetailFragment
import com.example.nguyenthanhtungh.moviedb.ui.main.MainActivity
import com.example.nguyenthanhtungh.moviedb.util.DETAIL_FRAGMENT
import com.example.nguyenthanhtungh.moviedb.util.ITEM_DECORATION
import com.example.nguyenthanhtungh.moviedb.util.SPAN_COUNT
import org.koin.android.viewmodel.ext.android.getViewModel

class HomeFragment : Fragment(), OnItemMovieClick {

    override fun onClick(movie: Movie) {
        if (activity is MainActivity)
            (activity as MainActivity).apply {
                replaceFragment(DetailFragment.newInstance(), R.id.frame_layout,
                        DETAIL_FRAGMENT, true)
            }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //initViewModel
        val viewModel = getViewModel<HomeViewModel>()
        //initViewBinding
        val homeBinding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeBinding.homeViewModel = viewModel
        //initRecycler
        viewModel.apply {
            getListDiscoverMovie()
            listDiscover.observe(this@HomeFragment, Observer {
                val listMovieAdapter = FragmentHomeAdapter(this@HomeFragment, it)
                val gridLayoutManager = GridLayoutManager(context, SPAN_COUNT)
                val itemDecoration: Int = ITEM_DECORATION
                homeBinding.recyclerHome.apply {
                    adapter = listMovieAdapter
                    layoutManager = gridLayoutManager
                    addItemDecoration(RecyclerItemDecoration(itemDecoration))
                }
            })
        }
        return homeBinding.root
    }
}
