package com.lukianbat.weatherexpert.feature.weather.presentation.city

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukianbat.weatherexpert.feature.weather.domain.usecase.GetCitiesUseCase
import com.lukianbat.weatherexpert.shared.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityViewModel(
    private val citiesUseCase: GetCitiesUseCase
) : ViewModel() {

    private val citiesRequest = MutableLiveData<Resource<List<String>>>()
    val cities: LiveData<Resource<List<String>>> = citiesRequest

    init {
        getCities()
        cities.observeForever {
            Log.i("TESTLOG", it.toString())
        }
    }

    private fun getCities() {
        viewModelScope.launch(Dispatchers.IO) {
            citiesRequest.postValue(Resource.loading(data = null))
            try {
                citiesRequest.postValue(
                    Resource.success(
                        data = citiesUseCase()
                            .map {
                                Log.i("TESTLOG", it.toString())
                                it.name
                            }
                    )
                )
            } catch (exception: Exception) {
                citiesRequest.postValue(
                    Resource.error(
                        data = null,
                        message = exception.message ?: "Error Occurred!"
                    )
                )
            }
        }
    }
}