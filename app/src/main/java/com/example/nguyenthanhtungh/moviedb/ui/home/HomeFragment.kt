package com.example.nguyenthanhtungh.moviedb.ui.home

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nguyenthanhtungh.moviedb.BR
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.base.BaseFragment
import com.example.nguyenthanhtungh.moviedb.base.RecyclerItemDecoration
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.databinding.FragmentHomeBinding
import com.example.nguyenthanhtungh.moviedb.util.ITEM_DECORATION
import com.example.nguyenthanhtungh.moviedb.util.SPAN_COUNT
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }

    override val layoutId = R.layout.fragment_home
    override val viewModel by viewModel<HomeViewModel>()
    override val bindingVariable: Int = BR.homeViewModel

    override fun initComponent(viewDataBinding: FragmentHomeBinding) {
        val fragmentHomeAdapter = FragmentHomeAdapter(
                onItemClick = { goToDetailFragment(it) }
        )

        val decoration = RecyclerItemDecoration(ITEM_DECORATION)

        viewDataBinding.apply {
            recyclerHome.apply {
                adapter = fragmentHomeAdapter
                layoutManager = GridLayoutManager(context, SPAN_COUNT)
                addItemDecoration(decoration)
            }
        }
        viewModel.apply {
            listDiscover.observe(this@HomeFragment, Observer {
                fragmentHomeAdapter.submitList(it)
            })
            getListDiscoverMovie(1)
        }
    }

    private fun goToDetailFragment(movie: Movie) {
        //todo
        Toast.makeText(activity, TAG,Toast.LENGTH_SHORT).show()
    }
}
