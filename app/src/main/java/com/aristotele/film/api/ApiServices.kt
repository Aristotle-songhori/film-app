package com.aristotele.film.api

import com.aristotele.film.models.BodyRegister
import com.aristotele.film.models.ResponseRegister
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {

    @POST(value = "register")
    suspend fun registerUser(
        @Body body: BodyRegister
    ): Response<ResponseRegister>

}