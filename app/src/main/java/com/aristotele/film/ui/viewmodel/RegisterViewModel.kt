package com.aristotele.film.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aristotele.film.models.register.BodyRegister
import com.aristotele.film.models.register.ResponseRegister
import com.aristotele.film.repository.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: RegisterRepository) : ViewModel() {

    val registerUser = MutableLiveData<ResponseRegister>()
    val loading = MutableLiveData<Boolean>()

    fun sendRegisterUser(body: BodyRegister) = viewModelScope.launch {


            //کنترل انجام عملیات
            loading.postValue(true)


//        کال کردن و دادن جوابش به یه مقدار
            val response = repository.registerUser(body)
            Log.i("###-Aristotele", "A-1-response $response")

            if (response.isSuccessful) {
                Log.i("###-Aristotele", "A-2-response.isSuccessful ==>  $response")
                Log.i("###-Aristotele", "A-3-response.body().toString()==> ${response.body().toString()}")
                registerUser.postValue(response.body())
            }else{
                Log.i("###-Aristotele", "A-4-response not successful response.message() ==> ${response.message()}")
                Log.i("###-Aristotele", "A-4-response not successful  response.errorBody() ==> ${response.errorBody().toString()}")
            }




            //کنترل انجام املیات
            loading.postValue(false)

        }


}