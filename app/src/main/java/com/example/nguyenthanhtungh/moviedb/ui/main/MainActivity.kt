package com.example.nguyenthanhtungh.moviedb.ui.main

import android.os.Bundle
import android.view.MenuItem
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.base.BaseActivity
import com.example.nguyenthanhtungh.moviedb.ui.favourite.FavouriteFragment
import com.example.nguyenthanhtungh.moviedb.ui.search.SearchFragment
import com.example.nguyenthanhtungh.moviedb.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>(), BottomNavigationView.OnNavigationItemSelectedListener {
    override val viewModel: MainViewModel = MainViewModel()

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initComponent(savedInstanceState: Bundle?) {
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        replaceFragment(HomeFragment.newInstance(), R.id.frame_layout, HomeFragment.TAG, false)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.item_home -> replaceFragment(HomeFragment.newInstance(), R.id.frame_layout, HomeFragment.TAG, false)
            R.id.item_favorite -> replaceFragment(FavouriteFragment.newInstance(), R.id.frame_layout, FavouriteFragment.TAG, false)
            R.id.item_search -> replaceFragment(SearchFragment.newInstance(), R.id.frame_layout, SearchFragment.TAG, false)
        }
        return true
    }
}
