package com.ovais.foodfusion.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ovais.foodfusion.features.bottomnavigation.BottomNavigationScreen
import com.ovais.foodfusion.features.home.presentation.HomeScreen
import com.ovais.foodfusion.features.onboarding.presentation.OnBoarding

class Navigation(
    private val dataProvider: NavigationDataProvider
) {

    private val startDestination: Screens
        get() = if (dataProvider.isFirstUse) Screens.OnBoarding else Screens.BottomNavigationScreen

    @Composable
    fun Navigate() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = startDestination.route) {
            composable(route = Screens.OnBoarding.route) {
                OnBoarding(navController = navController)
            }
            composable(Screens.BottomNavigationScreen.route) {
                BottomNavigationScreen()
            }
        }
    }
}