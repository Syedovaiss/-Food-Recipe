package com.ovais.foodfusion.common.navigation

sealed class Screens(val route: String) {
    object OnBoarding : Screens("on_boarding")

    object BottomNavigationScreen: Screens("bottom_navigation")
    object Home : Screens("home")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            append("/$args")
        }
    }
}