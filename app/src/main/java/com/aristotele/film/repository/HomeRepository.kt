package com.aristotele.film.repository

import com.aristotele.film.api.ApiServices
import com.aristotele.film.models.BodyRegister
import javax.inject.Inject

/**
 * مخزن قسمت رجیستر
 * که میاد درخواست رجیستر کال میکنه
 * و باید حتما اینترفیس سرویس رو اینجکت کنیم که داشته باشیم
 */
class HomeRepository @Inject constructor(private val api: ApiServices) {
    suspend fun topMoviesList(id: Int) = api.moviesTopList(id)
    suspend fun genresList() = api.genresList()
    suspend fun lastMoviesList() = api.moviesLastList()}