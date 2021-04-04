package com.lukianbat.weatherexpert.feature.weather.data.network.gateway

import com.lukianbat.weatherexpert.feature.weather.data.network.CitiesApi
import com.lukianbat.weatherexpert.feature.weather.data.network.mapper.ApiMapper.toDomain
import com.lukianbat.weatherexpert.feature.weather.domain.model.CityModel

class CitiesGateway(private val citiesApi: CitiesApi) {
    suspend fun getCitiesList(namePrefix: String): List<CityModel> {
        return citiesApi.getCities(namePrefix)
            .toDomain()
    }
}
