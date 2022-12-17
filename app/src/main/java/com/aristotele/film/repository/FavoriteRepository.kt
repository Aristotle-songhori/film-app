package com.aristotele.film.repository


import com.aristotele.film.db.MoviesDao
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val dao: MoviesDao) {

    fun allFavoriteList() = dao.getAllMovies()
}