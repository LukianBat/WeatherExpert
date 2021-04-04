package com.lukianbat.weatherexpert.shared.navigation

import androidx.navigation.NavController
import androidx.navigation.compose.navigate

fun NavController.navigateTo(route: String): () -> Unit = {
	this.navigate(route)
}

fun NavController.replace(route: String): () -> Unit = {
	this.navigate(route) {
		popUpTo(this@replace.graph.id) { inclusive = true }
	}
}