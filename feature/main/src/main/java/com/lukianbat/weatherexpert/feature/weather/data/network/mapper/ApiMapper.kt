package com.lukianbat.weatherexpert.feature.weather.data.network.mapper

import com.lukianbat.weatherexpert.feature.weather.data.network.model.CitiesResponse
import com.lukianbat.weatherexpert.feature.weather.data.network.model.WeatherResponse
import com.lukianbat.weatherexpert.feature.weather.domain.model.CityModel
import com.lukianbat.weatherexpert.feature.weather.domain.model.WeatherModel

internal object ApiMapper {
    private const val KELVIN_CELSIUS_DIFF = 273.15
    fun CitiesResponse.toDomain() = cities.map {
        CityModel(
            city = it.city,
            name = it.name,
            country = it.country,
            countryCode = it.countryCode,
            region = it.region,
            regionCode = it.regionCode,
            latitude = it.latitude,
            longitude = it.longitude
        )
    }

    fun WeatherResponse.toDomain(): WeatherModel {
        return WeatherModel(
            description = weatherDescription.firstOrNull()?.description ?: "",
            icon = weatherDescription.firstOrNull()?.icon,
            temp = main.temp.toCelsius(),
            feelsLikeTemp = main.feelsLike.toCelsius(),
            minTemp = main.tempMin.toCelsius(),
            maxTemp = main.tempMax.toCelsius(),
            humidity = main.humidity,
            windSpeed = wind.speed,
        )
    }

    fun Double.toCelsius() = this - KELVIN_CELSIUS_DIFF
}