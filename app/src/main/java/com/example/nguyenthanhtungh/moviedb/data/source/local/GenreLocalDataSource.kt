package com.example.nguyenthanhtungh.moviedb.data.source.local

import com.example.nguyenthanhtungh.moviedb.data.model.Genre
import com.example.nguyenthanhtungh.moviedb.data.source.GenreDataSource
import com.example.nguyenthanhtungh.moviedb.data.source.local.dao.GenreDao
import io.reactivex.Single

class GenreLocalDataSource(private val genreDao: GenreDao) : GenreDataSource.LocalDataSource {

    override fun deleteGenreLocal(id: String) {
        return genreDao.deleteGenre(id)
    }

    override fun getListGenresLocal(): Single<List<Genre>> {
        return genreDao.getGenreList()
    }

    override fun insertListGenresLocal(list: List<Genre>) {
        return genreDao.insert(list)
    }

    override fun updateListGenresLocal(genre: Genre) {
        return genreDao.update(genre)
    }
}
