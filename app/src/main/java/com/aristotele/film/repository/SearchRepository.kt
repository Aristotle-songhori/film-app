package com.aristotele.film.repository

import com.aristotele.film.api.ApiServices
import javax.inject.Inject

class SearchRepository @Inject constructor(private val api: ApiServices){
    suspend fun searchMovie(name:String) = api.searchMovie(name)
}