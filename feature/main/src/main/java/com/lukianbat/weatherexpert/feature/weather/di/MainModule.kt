package com.lukianbat.weatherexpert.feature.weather.di

import com.lukianbat.weatherexpert.feature.weather.domain.usecase.ChooseCityUseCase
import com.lukianbat.weatherexpert.feature.weather.domain.usecase.GetCitiesUseCase
import com.lukianbat.weatherexpert.feature.weather.domain.usecase.GetWeatherUseCase
import com.lukianbat.weatherexpert.feature.weather.presentation.city.CityViewModel
import com.lukianbat.weatherexpert.feature.weather.presentation.weather.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val mainModule = module {
    loadKoinModules(
        listOf(
            networkModule,
            dataStoreModule
        )
    )
    factory { GetCitiesUseCase(get()) }
    factory { ChooseCityUseCase(get()) }
    factory { GetWeatherUseCase(get(), get()) }

    viewModel { CityViewModel(get()) }
    viewModel { WeatherViewModel(get()) }
}
