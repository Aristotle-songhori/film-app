package com.aristotele.film.repository

import com.aristotele.film.api.ApiServices
import com.aristotele.film.models.BodyRegister
import javax.inject.Inject


class RegisterRepository @Inject constructor( private val api: ApiServices) {
suspend fun registerUser(body: BodyRegister) = api.registerUser(body)
}