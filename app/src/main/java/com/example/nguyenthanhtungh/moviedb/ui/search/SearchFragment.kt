package com.example.nguyenthanhtungh.moviedb.ui.search

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toast
import com.example.nguyenthanhtungh.moviedb.BR
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.base.BaseFragment
import com.example.nguyenthanhtungh.moviedb.databinding.FragmentSearchBinding
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.nguyenthanhtungh.moviedb.base.EndlessScrollListener
import com.example.nguyenthanhtungh.moviedb.base.RecyclerItemDecoration
import com.example.nguyenthanhtungh.moviedb.data.model.Movie
import com.example.nguyenthanhtungh.moviedb.ui.detail.DetailFragment
import com.example.nguyenthanhtungh.moviedb.ui.main.MainActivity
import com.example.nguyenthanhtungh.moviedb.util.ITEM_DECORATION
import com.example.nguyenthanhtungh.moviedb.util.SPAN_COUNT

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = SearchFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override val layoutId = R.layout.fragment_search
    override val viewModel by viewModel<SearchViewModel>()
    override val bindingVariable: Int = BR.searchViewModel

    override fun initComponent(viewDataBinding: FragmentSearchBinding) {

        val fragmentSearchAdapter = FragmentSearchAdapter(
                onItemClick = {
                    goToDetailFragment(it)
                }
        )

        val decoration = RecyclerItemDecoration(ITEM_DECORATION)
        val endlessScrollListener = EndlessScrollListener {
            viewModel.onLoadMore(viewModel.queryString.value ?: "")
        }

        viewDataBinding.apply {
            recyclerSearch.apply {
                adapter = fragmentSearchAdapter
                layoutManager = GridLayoutManager(context, SPAN_COUNT)
                addItemDecoration(decoration)
                addOnScrollListener(endlessScrollListener)
            }
        }

        (activity as MainActivity).setSupportActionBar(viewDataBinding.toolbar)

        viewModel.apply {
            queryString.observe(this@SearchFragment, Observer {

                listSearch.observe(this@SearchFragment, Observer {
                    when (it.size) {
                        0 -> Toast.makeText(context, getString(R.string.no_search_result), Toast.LENGTH_SHORT).show()
                        else -> fragmentSearchAdapter.submitList(it)
                    }
                })
                firstLoad(it)

                isLoadMore.observe(this@SearchFragment, Observer {
                    if (it == null) return@Observer
                    endlessScrollListener.isLoading = it
                })

                loadError.observe(this@SearchFragment, Observer {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                })
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.search_view, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        searchView.queryHint = getString(R.string.app_name)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.queryString.value = query
                searchItem.collapseActionView()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
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
