package com.aristotele.film.models

import android.view.ViewDebug.IntToString
import com.google.gson.annotations.SerializedName

data class BodyRegister(
    @SerializedName("name") var name: String? ="", // "abbas"
    @SerializedName("email") var email: String? = "", // "abbas@oveissi.ir"
    @SerializedName("password") var password: String? = "" // "2shy46wrh734@#%"
)