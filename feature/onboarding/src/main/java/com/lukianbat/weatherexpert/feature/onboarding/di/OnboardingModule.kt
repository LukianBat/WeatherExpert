package com.lukianbat.weatherexpert.feature.onboarding.di

import com.lukianbat.weatherexpert.feature.onboarding.domain.PassOnboardingUseCase
import com.lukianbat.weatherexpert.feature.onboarding.presentation.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {
	factory { PassOnboardingUseCase(get()) }

	viewModel { OnboardingViewModel(get()) }
}