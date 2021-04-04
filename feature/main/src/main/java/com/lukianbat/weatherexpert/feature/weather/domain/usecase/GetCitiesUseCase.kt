package com.lukianbat.weatherexpert.feature.weather.domain.usecase

import com.lukianbat.weatherexpert.feature.weather.data.network.gateway.CitiesGateway

class GetCitiesUseCase(private val citiesGateway: CitiesGateway) {
    suspend operator fun invoke(namePrefix: String = "") = citiesGateway.getCitiesList(namePrefix)
}
