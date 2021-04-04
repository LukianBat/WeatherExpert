package com.lukianbat.weatherexpert.feature.weather.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lukianbat.weatherexpert.feature.weather.presentation.MainScreen
import com.lukianbat.weatherexpert.feature.weather.presentation.city.CityScreen
import com.lukianbat.weatherexpert.shared.navigation.navigateTo
import com.lukianbat.weatherexpert.shared.navigation.replace

object MainDestinations {

    const val CITIES = "CITIES"
    const val START = "START"
    const val WHEATHER = "WHEATHER"
}

class MainActions(navController: NavController) {

    val navigateToCities = navController.replace(MainDestinations.CITIES)

    val navigateToWheather = navController.navigateTo(MainDestinations.WHEATHER)
}

@Composable
fun MainNavigationGraph() {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }

    NavHost(navController, MainDestinations.START) {
        composable(MainDestinations.START) {
            MainScreen(actions.navigateToCities, actions.navigateToWheather)
        }
        composable(MainDestinations.CITIES) {
            CityScreen(actions.navigateToWheather)
        }
    }
}