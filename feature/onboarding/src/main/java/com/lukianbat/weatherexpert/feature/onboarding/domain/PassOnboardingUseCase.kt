package com.lukianbat.weatherexpert.feature.onboarding.domain

import com.lukianbat.weatherexpert.shared.preferences.data.PreferencesRepository
import com.lukianbat.weatherexpert.shared.preferences.domain.model.PreferencesKeys

class PassOnboardingUseCase(
	private val preferencesRepository: PreferencesRepository
) {

	suspend operator fun invoke() {
		preferencesRepository.setBoolean(PreferencesKeys.ONBOARDING_PASSED, true)
	}
}