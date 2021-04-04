package com.lukianbat.weatherexpert.feature.weather.presentation.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukianbat.weatherexpert.feature.weather.domain.model.WeatherModel
import com.lukianbat.weatherexpert.feature.weather.domain.usecase.GetWeatherUseCase
import com.lukianbat.weatherexpert.shared.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val weatherRequest = MutableLiveData<Resource<WeatherModel>>()
    val weather: LiveData<Resource<WeatherModel>> = weatherRequest

    init {
        loadWeather()
    }

    private fun loadWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            weatherRequest.postValue(Resource.loading(data = null))
            weatherUseCase()
                .catch {
                    weatherRequest.postValue(
                        Resource.error(
                            data = null,
                            message = it.message ?: "Error Occurred!"
                        )
                    )
                }
                .collect {
                    weatherRequest.postValue(Resource.success(data = it))
                }
        }
    }
}
