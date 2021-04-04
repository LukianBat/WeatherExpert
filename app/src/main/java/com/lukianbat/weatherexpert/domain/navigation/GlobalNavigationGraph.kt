package com.lukianbat.weatherexpert.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.lukianbat.weatherexpert.feature.onboarding.presentation.OnboardingScreen
import com.lukianbat.weatherexpert.shared.navigation.replace
import com.lukianbat.weatherexpert.feature.splash.presentation.SplashScreen
import com.lukianbat.weatherexpert.feature.weather.domain.navigation.MainDestinations
import com.lukianbat.weatherexpert.feature.weather.domain.navigation.MainNavigationGraph

object GlobalDestinations {

    const val SPLASH = "SPLASH"
    const val MAIN = "MAIN"
    const val ONBOARDING = "ONBOARDING"
}

class GlobalActions(navController: NavController) {

    val navigateToMain = navController.replace(GlobalDestinations.MAIN)
    val navigateToOnboarding = navController.replace(GlobalDestinations.ONBOARDING)
}

@Composable
fun GlobalNavigationGraph() {
    val navController = rememberNavController()

    val actions = remember(navController) { GlobalActions(navController) }

    NavHost(navController, GlobalDestinations.SPLASH) {
        composable(GlobalDestinations.SPLASH) {
            SplashScreen(actions.navigateToMain, actions.navigateToOnboarding)
        }
        composable(GlobalDestinations.ONBOARDING) {
            OnboardingScreen(actions.navigateToMain)
        }
        navigation(
            startDestination = MainDestinations.START,
            route = GlobalDestinations.MAIN
        ) {
            composable(MainDestinations.START) {
                MainNavigationGraph()
            }
        }
    }
}