package com.lukianbat.weatherexpert.feature.weather.data.network.gateway

import com.lukianbat.weatherexpert.feature.weather.data.network.WeatherApi
import com.lukianbat.weatherexpert.feature.weather.data.network.mapper.ApiMapper.toDomain
import com.lukianbat.weatherexpert.feature.weather.domain.model.CityModel
import com.lukianbat.weatherexpert.feature.weather.domain.model.WeatherModel

class WeatherGateway(private val weatherApi: WeatherApi) {
    suspend fun getWeather(cityModel: CityModel): WeatherModel {
        return weatherApi.getWeather(
            "${cityModel.name},${cityModel.regionCode},${cityModel.countryCode}"
        )
            .toDomain()
    }
}
