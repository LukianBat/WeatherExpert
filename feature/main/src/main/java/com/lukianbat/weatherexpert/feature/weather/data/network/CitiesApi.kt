package com.lukianbat.weatherexpert.feature.weather.data.network

import com.lukianbat.weatherexpert.feature.weather.data.network.model.CitiesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CitiesApi {
    @GET("cities")
    suspend fun getCities(@Query("namePrefix") namePrefix: String): CitiesResponse
}