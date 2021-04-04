package com.lukianbat.weatherexpert

import android.app.Application
import com.lukianbat.weatherexpert.feature.onboarding.di.onboardingModule
import com.lukianbat.weatherexpert.shared.preferences.di.preferencesModule
import com.lukianbat.weatherexpert.feature.splash.di.splashModule
import com.lukianbat.weatherexpert.feature.weather.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidLogger()
			androidContext(this@App)
			modules(
				preferencesModule,
				splashModule,
				onboardingModule,
				mainModule
			)
		}
	}
}