package com.lukianbat.weatherexpert.feature.weather.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import com.lukianbat.weatherexpert.feature.main.CityPreferences
import com.lukianbat.weatherexpert.feature.weather.data.local.CitySerializer
import com.lukianbat.weatherexpert.feature.weather.data.local.gateway.ChosenCityGateway
import com.lukianbat.weatherexpert.feature.weather.data.local.repository.CityRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val CITY_DATA_STORE = "CITY_DATA_STORE"

val dataStoreModule = module {
    single(qualifier = named(name = CITY_DATA_STORE)) { createDataStore(get()) }
    single { CityRepository(get(qualifier = named(name = CITY_DATA_STORE))) }
    single { ChosenCityGateway(get()) }
}

fun createDataStore(context: Context): DataStore<CityPreferences> =
    context.createDataStore(
        fileName = "city_prefs.pb",
        serializer = CitySerializer
    )