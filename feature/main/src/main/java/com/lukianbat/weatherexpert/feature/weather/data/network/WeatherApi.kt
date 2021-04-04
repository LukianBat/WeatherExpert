package com.lukianbat.weatherexpert.feature.weather.data.network

import com.lukianbat.weatherexpert.feature.weather.data.network.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(@Query("q") cityData: String): WeatherResponse
}
