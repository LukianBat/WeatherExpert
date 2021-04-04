package com.lukianbat.weatherexpert.feature.weather.data.local.repository

import androidx.datastore.core.DataStore
import com.lukianbat.weatherexpert.feature.main.CityPreferences
import com.lukianbat.weatherexpert.feature.weather.data.local.DataStoreRepository
import com.lukianbat.weatherexpert.feature.weather.data.local.mapper.DBMapper.toDataStore
import com.lukianbat.weatherexpert.feature.weather.data.local.mapper.DBMapper.toDomain
import com.lukianbat.weatherexpert.feature.weather.domain.model.CityModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CityRepository(
    private val dataStore: DataStore<CityPreferences>
) : DataStoreRepository<CityModel> {

    override fun getPreference(): Flow<CityModel> = dataStore.data.map { it.toDomain() }

    override suspend fun editPreference(data: CityModel) {
        dataStore.updateData {
            data.toDataStore()
        }
    }
}
