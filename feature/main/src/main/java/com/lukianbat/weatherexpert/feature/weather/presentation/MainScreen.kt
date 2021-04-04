package com.lukianbat.weatherexpert.feature.weather.presentation

import androidx.compose.runtime.Composable

@Composable
fun MainScreen(
    navigateToCity: () -> Unit,
    navigateToWheather: () -> Unit
) {
    navigateToCity()
}