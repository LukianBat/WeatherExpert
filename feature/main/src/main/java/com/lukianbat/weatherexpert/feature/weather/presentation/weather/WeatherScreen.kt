package com.lukianbat.weatherexpert.feature.weather.presentation.weather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.lukianbat.weatherexpert.feature.weather.domain.model.WeatherModel
import com.lukianbat.weatherexpert.shared.network.Resource
import org.koin.androidx.compose.getViewModel

@Composable
fun WeatherScreen(
    navigateToMain: () -> Unit,
    navigateToOnboarding: () -> Unit,
    viewModel: WeatherViewModel = getViewModel()
) {
    val weather: Resource<WeatherModel>? by viewModel.weather.observeAsState()

}