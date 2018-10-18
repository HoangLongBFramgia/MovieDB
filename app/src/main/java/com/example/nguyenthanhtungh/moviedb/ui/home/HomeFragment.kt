package com.example.nguyenthanhtungh.moviedb.ui.home

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.nguyenthanhtungh.moviedb.BR
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.base.BaseFragment
import com.example.nguyenthanhtungh.moviedb.base.EndlessScrollListener
import com.example.nguyenthanhtungh.moviedb.base.RecyclerItemDecoration
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.databinding.FragmentHomeBinding
import com.example.nguyenthanhtungh.moviedb.ui.detail.DetailFragment
import com.example.nguyenthanhtungh.moviedb.ui.main.MainActivity
import com.example.nguyenthanhtungh.moviedb.util.ITEM_DECORATION
import com.example.nguyenthanhtungh.moviedb.util.SPAN_COUNT
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(),
        SwipeRefreshLayout.OnRefreshListener {

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }

    override val layoutId = R.layout.fragment_home
    override val viewModel by viewModel<HomeViewModel>()
    override val bindingVariable: Int = BR.homeViewModel

    override fun initComponent(viewDataBinding: FragmentHomeBinding) {

        val fragmentHomeAdapter = FragmentHomeAdapter(
                onItemClick = {
                    goToDetailFragment(it)
                }
        )

        val endlessScrollListener = EndlessScrollListener { viewModel.onLoadMore() }
        val decoration = RecyclerItemDecoration(ITEM_DECORATION)
        viewDataBinding.apply {
            recyclerHome.apply {
                adapter = fragmentHomeAdapter
                layoutManager = GridLayoutManager(context, SPAN_COUNT)
                addItemDecoration(decoration)
                addOnScrollListener(endlessScrollListener)
            }
        }
        viewBinding.swipeLayout.setOnRefreshListener(this@HomeFragment)

        viewModel.apply {
            listDiscoverMovie.observe(this@HomeFragment, Observer {
                fragmentHomeAdapter.submitList(it)
            })
            firstLoad()

            isRefresh.observe(this@HomeFragment, Observer {
                viewBinding.swipeLayout.apply { isRefreshing = it == true }
            })

            isLoadMore.observe(this@HomeFragment, Observer {
                if (it == null) return@Observer
                endlessScrollListener.isLoading = it
            })

            loadError.observe(this@HomeFragment, Observer {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
        }
    }

    override fun onRefresh() {
        viewModel.refreshData()
    }

    private fun goToDetailFragment(movie: Movie) {
        if (activity is MainActivity)
            (activity as MainActivity).apply {
                val movieDetailFragment = DetailFragment.newInstance(movie)
                addFragment(movieDetailFragment,
                        R.id.frame_layout, DetailFragment.TAG, true)
            }
    }
}
