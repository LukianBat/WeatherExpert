package com.lukianbat.weatherexpert.feature.weather.domain.usecase

import com.lukianbat.weatherexpert.feature.weather.data.local.gateway.ChosenCityGateway
import com.lukianbat.weatherexpert.feature.weather.data.network.gateway.WeatherGateway
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf

class GetWeatherUseCase(
    private val chosenCityGateway: ChosenCityGateway,
    private val weatherGateway: WeatherGateway
) {
    suspend operator fun invoke() = chosenCityGateway.getChosenCity()
        .flatMapLatest {
            flowOf(weatherGateway.getWeather(it))
        }
}
