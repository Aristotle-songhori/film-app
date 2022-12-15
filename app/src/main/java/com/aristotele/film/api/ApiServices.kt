package com.aristotele.film.api

import com.aristotele.film.models.BodyRegister
import com.aristotele.film.models.ResponseRegister
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


/**
 *این بخش درست میشه برای تعریف درخواست ها
 * در رتروفیت
 */

interface ApiServices {

    /**
     * در زیر یه ساسپند فانکشن میبینید که یه درخواست پست رو مدیریت میکنه
     * داده هایی که باید ارسال بشه به شکل یه آبجکت داده شده به اسم بدنه
     * و توسط هیلت معرفی شده و با اتساین بادی به اینجا تزریق شده
     * و جواب به اسم ریسپوند برمیگردونه به ما
     * انوتیشن پست داره و مقدار register هم همون مقداری بعد از آدرس اصلی هست
     * https://moviesapi.ir/api/v1/register
     * مقداری که ما میفرستیم در ماژول ها طراحی کردیم  و هست
     * body
     * و مقداری که میگیریم هم همونجا تعریف کردیم که میشه
     * ResponseRegister
     */
    @POST(value = "register")
    suspend fun registerUser(@Body body: BodyRegister): Response<ResponseRegister>

}