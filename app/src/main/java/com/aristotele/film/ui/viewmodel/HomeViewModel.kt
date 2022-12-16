package com.aristotele.film.ui.viewmodel

import academy.nouri.s1_project.models.home.ResponseGenresList
import academy.nouri.s1_project.models.home.ResponseMoviesList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aristotele.film.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    /**
     * 3 تا درخواست تو این فرگمنت داریم
     * یکی برای بالای صفحه
     * یکی وسط و یگی پایین
     * ولی برای آخری لود شدن رو ست میکنیم که آخرین فرمان هست
     * چون تو کروتین که صدا میکنیم آخرین هست
     */
    val topMoviesList = MutableLiveData<ResponseMoviesList>()
    val genresList = MutableLiveData<ResponseGenresList>()
    val lastMoviesList = MutableLiveData<ResponseMoviesList>()


    /**
     * فقط یه لودینگ بگذاریم بهتره میشه 3 تا هم قرارداد ولی جالب نمیشه
     * که برای آخری قرار میدیم
     */
    val loading = MutableLiveData<Boolean>()

    fun loadTopMoviesList(id: Int) = viewModelScope.launch {
        val response = repository.topMoviesList(id)
        if (response.isSuccessful) {
            topMoviesList.postValue(response.body())
        }
    }

    fun loadGenresList() = viewModelScope.launch {
        val response = repository.genresList()
        if (response.isSuccessful) {
            genresList.postValue(response.body())
        }
    }

    fun loadLastMoviesList() = viewModelScope.launch {
        loading.postValue(true)
        val response = repository.lastMoviesList()
        if (response.isSuccessful) {
            lastMoviesList.postValue(response.body())
        }
        loading.postValue(false)
    }

}