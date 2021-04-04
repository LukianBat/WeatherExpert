package com.lukianbat.weatherexpert.shared.preferences.data

import androidx.datastore.preferences.core.Preferences

interface PreferencesRepository {

    suspend fun getString(key: Preferences.Key<String>): String?

    suspend fun getBoolean(key: Preferences.Key<Boolean>): Boolean?

    suspend fun setString(key: Preferences.Key<String>, value: String)

    suspend fun setBoolean(key: Preferences.Key<Boolean>, value: Boolean)
}