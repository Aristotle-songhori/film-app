package com.aristotele.film.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * تعریف یک دیتا استور به این صورته
 * البته و 100 البته توسط هیلت دجر
 *
 */
class StoreUserData @Inject constructor(@ApplicationContext val context: Context) {

    /**
     * این مقادیر در اینجا هستند که از همه جا قابل دست رسی باشند
     */
    companion object{
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(Constants.USER_INFO_DATASTORE)
        val userToken = stringPreferencesKey(Constants.USER_TOKEN)
    }

    /**
     *     تابع نویسنده در حافظه
     */
    suspend fun saveUserToken(token: String){ context.dataStore.edit { it[userToken]=token } }

    /**
     * تابه خواندن از حافظه
     */
    fun getUserToken() =context.dataStore.data.map { it[userToken] ?: "" }

    }

