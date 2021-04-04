package com.lukianbat.weatherexpert.feature.weather.data.local.mapper

import com.lukianbat.weatherexpert.feature.main.CityPreferences
import com.lukianbat.weatherexpert.feature.weather.domain.model.CityModel

internal object DBMapper {
    fun CityPreferences.toDomain() = CityModel(
        city = city,
        name = name,
        country = country,
        countryCode = countryCode,
        region = region,
        regionCode = regionCode,
        latitude = latitude,
        longitude = longitude
    )

    fun CityModel.toDataStore() = CityPreferences.newBuilder()
        .setCity(city)
        .setName(name)
        .setCountry(country)
        .setCountryCode(countryCode)
        .setRegion(region)
        .setRegionCode(regionCode)
        .setLatitude(latitude)
        .setLongitude(longitude)
        .build()
}