package com.aristotele.film.models.register

import com.google.gson.annotations.SerializedName


/**
 * این چی ؟
 * این یه سری داده بودکه ما نیاز داشتیم به صورت جیسن به هاست بفرستیم با متد پست
 * تا بتونیم مشخصات کاربر رو بگیریم
 * https://moviesapi.ir/api/v1/register
 * در بخش Api
 *ثبت کاربر جدید
با استفاده از این متد می‌توانید یک کاربر جدید جدید در وب‌سرویس ثبت‌نام کنید. اطلاعات کاربر (نام، ایمیل و پسورد) باید با فرمت Json در Body درخواست ارسال شون.*
 *
 * دفت کنیددددددددددددددددددددددددددد
 * اینجا مقدار پیش فرض خالی برای همه گزینه ها باید تعریف کنید تا در تعریف های جلو تر و استفاده به مشکل نخورید
 * همینطور که میبینید همه مقادیر پیش فرض دارن و خالی هستن
 */
data class BodyRegister(
    @SerializedName("name") var name: String = "",
    @SerializedName("email") var email: String = "",
    @SerializedName("password") var password: String = ""
)
