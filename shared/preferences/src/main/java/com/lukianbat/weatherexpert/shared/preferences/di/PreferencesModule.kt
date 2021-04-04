package com.lukianbat.weatherexpert.shared.preferences.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import com.lukianbat.weatherexpert.shared.preferences.data.PreferencesRepositoryImpl
import com.lukianbat.weatherexpert.shared.preferences.data.PreferencesRepository
import org.koin.dsl.module

private const val SETTINGS_NAME = "com.lukianbat.wheatherexpert.settings"

val preferencesModule = module {

    fun createDataStore(context: Context): DataStore<Preferences> =
        context.createDataStore(SETTINGS_NAME)

    single { createDataStore(get()) }

    factory<PreferencesRepository> { PreferencesRepositoryImpl(get()) }
}