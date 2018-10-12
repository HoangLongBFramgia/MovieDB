package com.example.nguyenthanhtungh.moviedb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.databinding.FragmentHomeBinding
import com.example.nguyenthanhtungh.moviedb.util.SPAN_COUNT
import org.koin.android.viewmodel.ext.android.getViewModel

class HomeFragment : Fragment() {

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
                val listMovieAdapter = FragmentHomeAdapter(it)
                val gridLayoutManager = GridLayoutManager(context, SPAN_COUNT)
                homeBinding.recyclerGenre.apply {
                    adapter = listMovieAdapter
                    layoutManager = gridLayoutManager
                }
            })
        }
        return homeBinding.root
    }
}
