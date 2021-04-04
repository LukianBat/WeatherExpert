package com.lukianbat.weatherexpert.feature.weather.domain.usecase

import com.lukianbat.weatherexpert.feature.weather.data.local.gateway.ChosenCityGateway
import com.lukianbat.weatherexpert.feature.weather.domain.model.CityModel

class ChooseCityUseCase(private val chooseCityGateway: ChosenCityGateway) {
    suspend operator fun invoke(city: CityModel) = chooseCityGateway.chooseCity(city)
}
