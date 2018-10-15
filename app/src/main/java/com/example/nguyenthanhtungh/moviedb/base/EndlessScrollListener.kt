package com.example.nguyenthanhtungh.moviedb.base

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EndlessScrollListener(val onLoadMore: () -> Unit) : RecyclerView.OnScrollListener() {
    var isLoading = false

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        var pastItem = 0
        var visibleItem = 0
        var totalItem = 0
        when (recyclerView?.layoutManager) {
            is LinearLayoutManager -> {
                (recyclerView.layoutManager as LinearLayoutManager).apply {
                    pastItem = findFirstVisibleItemPosition()
                    visibleItem=childCount
                    totalItem = itemCount
                }
            }
            is GridLayoutManager -> {
                (recyclerView.layoutManager as GridLayoutManager).apply {
                    pastItem = findFirstVisibleItemPosition()
                    visibleItem = childCount
                    totalItem = itemCount
                }
            }
        }
        if (!isLoading && pastItem + visibleItem >= totalItem) {
            onLoadMore.invoke()
            isLoading = true
        }
    }
}
