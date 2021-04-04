package com.lukianbat.weatherexpert.shared.preferences.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class PreferencesRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : PreferencesRepository {

    override suspend fun getString(key: Preferences.Key<String>): String? {
        return dataStore.data.map { it[key] }.firstOrNull()
    }

    override suspend fun getBoolean(key: Preferences.Key<Boolean>): Boolean? {
        return dataStore.data.map { it[key] }.firstOrNull()
    }

    override suspend fun setString(key: Preferences.Key<String>, value: String) {
        dataStore.edit { it[key] = value }
    }

    override suspend fun setBoolean(key: Preferences.Key<Boolean>, value: Boolean) {
        dataStore.edit { it[key] = value }
    }
}