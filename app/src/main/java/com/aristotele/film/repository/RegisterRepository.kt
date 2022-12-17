package com.aristotele.film.repository

import com.aristotele.film.api.ApiServices
import com.aristotele.film.models.register.BodyRegister
import javax.inject.Inject

/**
 * مخزن قسمت رجیستر
 * که میاد درخواست رجیستر کال میکنه
 * و باید حتما اینترفیس سرویس رو اینجکت کنیم که داشته باشیم
 */
class RegisterRepository @Inject constructor( private val api: ApiServices) {
    suspend fun registerUser(body: BodyRegister) = api.registerUser(body)
}