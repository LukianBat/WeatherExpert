package com.lukianbat.weatherexpert.feature.weather.presentation.city

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lukianbat.weatherexpert.shared.network.Resource
import com.lukianbat.weatherexpert.shared.ui.ShortboxTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun CityScreen(
    navigateToWheather: () -> Unit,
    viewModel: CityViewModel = getViewModel()
) {
    val cities: Resource<List<String>>? by viewModel.cities.observeAsState()

    ShortboxTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Scaffold(
                bodyContent = {
                    Column {
                        Text(
                            text = "Выберите город",
                            style = MaterialTheme.typography.subtitle1,
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(cities?.data?.toString() ?: "")
                    }
                }
            )
        }
    }

}