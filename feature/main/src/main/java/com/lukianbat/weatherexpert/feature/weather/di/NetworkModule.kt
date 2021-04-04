package com.lukianbat.weatherexpert.feature.weather.di

import com.lukianbat.weatherexpert.feature.weather.data.network.CitiesApi
import com.lukianbat.weatherexpert.feature.weather.data.network.CitiesInterceptor
import com.lukianbat.weatherexpert.feature.weather.data.network.WeatherApi
import com.lukianbat.weatherexpert.feature.weather.data.network.WeatherInterceptor
import com.lukianbat.weatherexpert.feature.weather.data.network.gateway.CitiesGateway
import com.lukianbat.weatherexpert.feature.weather.data.network.gateway.WeatherGateway
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val CITIES_NETWORK_DEPENDENCY_NAME = "CITIES_NETWORK_DEPENDENCY_NAME"
private const val WEATHER_NETWORK_DEPENDENCY_NAME = "WEATHER_NETWORK_DEPENDENCY_NAME"

val networkModule = module {
    single { CitiesInterceptor() }
    single { WeatherInterceptor() }

    single(qualifier = named(CITIES_NETWORK_DEPENDENCY_NAME)) {
        provideCitiesOkHttpClient(get())
    }
    single(qualifier = named(WEATHER_NETWORK_DEPENDENCY_NAME)) {
        provideWheatherOkHttpClient(get())
    }

    single(qualifier = named(CITIES_NETWORK_DEPENDENCY_NAME)) {
        provideCitiesRetrofit(get(qualifier = named(CITIES_NETWORK_DEPENDENCY_NAME)))
    }
    single(qualifier = named(WEATHER_NETWORK_DEPENDENCY_NAME)) {
        provideWheatherRetrofit(get(qualifier = named(WEATHER_NETWORK_DEPENDENCY_NAME)))
    }

    single { provideCitiesApi(get(qualifier = named(CITIES_NETWORK_DEPENDENCY_NAME))) }
    single { provideWeatherApi(get(qualifier = named(WEATHER_NETWORK_DEPENDENCY_NAME))) }

    single { CitiesGateway(get()) }
    single { WeatherGateway(get()) }
}

fun provideCitiesRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("https://wft-geo-db.p.rapidapi.com/v1/geo/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideCitiesOkHttpClient(authInterceptor: CitiesInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()
}

fun provideWheatherOkHttpClient(weatherInterceptor: WeatherInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder()
        .addInterceptor(weatherInterceptor)
        .build()
}

fun provideWheatherRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("api.openweathermap.org/data/2.5/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideWeatherApi(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)

fun provideCitiesApi(retrofit: Retrofit): CitiesApi = retrofit.create(CitiesApi::class.java)