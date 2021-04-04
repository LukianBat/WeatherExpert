package com.lukianbat.weatherexpert.feature.weather.data.local

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository<T> {
    fun getPreference() : Flow<T>

    suspend fun editPreference(data: T)
}