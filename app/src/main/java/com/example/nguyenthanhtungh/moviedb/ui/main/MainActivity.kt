package com.example.nguyenthanhtungh.moviedb.ui.main

import android.os.Bundle
import android.view.MenuItem
import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.base.BaseActivity
import com.example.nguyenthanhtungh.moviedb.ui.favourite.FavouriteFragment
import com.example.nguyenthanhtungh.moviedb.ui.home.HomeFragment
import com.example.nguyenthanhtungh.moviedb.util.HOME_FRAGMENT
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        replaceFragment(HomeFragment.newInstance(), R.id.frame_layout, HOME_FRAGMENT, false)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.item_main -> replaceFragment(HomeFragment.newInstance(), R.id.frame_layout, "HomeFragment", false)
            R.id.item_favorite -> replaceFragment(FavouriteFragment.newInstance(), R.id.frame_layout, "HomeFragment", false)
        }
        return true
    }
}
