package com.lukianbat.weatherexpert.feature.splash.di

import com.lukianbat.weatherexpert.feature.splash.domain.IsOnboardingPassedUceCase
import com.lukianbat.weatherexpert.feature.splash.presentation.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
	factory { IsOnboardingPassedUceCase(get()) }

	viewModel { SplashViewModel(get()) }
}