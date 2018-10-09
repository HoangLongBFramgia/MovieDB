package com.example.nguyenthanhtungh.moviedb.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.nguyenthanhtungh.moviedb.R
import com.example.nguyenthanhtungh.moviedb.data.model.Genre
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val mGenres: List<Genre>) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.genre_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bindData(mGenres[position])
    }

    override fun getItemCount(): Int {
        return if (mGenres.isEmpty()) 0 else mGenres.size
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mTextName: TextView = itemView.findViewById(R.id.genre_item_name)
        private val mButtonSeeMore: Button = itemView.findViewById(R.id.genre_item_seemore)

        open fun bindData(genre: Genre) {
            mTextName.text = genre.name
        }
    }
}
