package com.lukianbat.weatherexpert.feature.splash.domain

import com.lukianbat.weatherexpert.shared.preferences.data.PreferencesRepository
import com.lukianbat.weatherexpert.shared.preferences.domain.model.PreferencesKeys.ONBOARDING_PASSED

class IsOnboardingPassedUceCase(
	private val preferencesRepository: PreferencesRepository
) {

	suspend operator fun invoke(): Boolean =
		preferencesRepository.getBoolean(ONBOARDING_PASSED) == true
}