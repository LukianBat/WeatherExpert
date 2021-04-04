package com.lukianbat.weatherexpert.feature.weather.data.local.gateway

import com.lukianbat.weatherexpert.feature.weather.data.local.repository.CityRepository
import com.lukianbat.weatherexpert.feature.weather.domain.model.CityModel

class ChosenCityGateway(
    private val cityRepository: CityRepository
) {
    suspend fun chooseCity(city: CityModel) {
        cityRepository.editPreference(city)
    }

    fun getChosenCity() = cityRepository.getPreference()
}
