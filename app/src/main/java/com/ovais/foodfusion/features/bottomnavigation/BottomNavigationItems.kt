package com.ovais.foodfusion.features.bottomnavigation

import com.ovais.foodfusion.R

sealed class BottomNavigationItems(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomNavigationItems(
        route = BottomNavScreens.HomeScreen.route,
        title = "Home",
        icon = R.drawable.ic_bottom_nav_home
    )

    object SavedRecipes : BottomNavigationItems(
        route = BottomNavScreens.SavedRecipesScreen.route,
        title = "Saved Recipes",
        icon = R.drawable.ic_bottom_nav_saved
    )

    object CreateRecipe : BottomNavigationItems(
        route = BottomNavScreens.AddRecipesScreen.route,
        title = "Create",
        icon = R.drawable.ic_bottom_nav_plus
    )

    object Notifications : BottomNavigationItems(
        route = BottomNavScreens.NotificationsScreen.route,
        title = "Notifications",
        icon = R.drawable.ic_bottom_nav_notifications
    )

    object Account : BottomNavigationItems(
        route = BottomNavScreens.AccountsScreen.route,
        title = "Account",
        icon = R.drawable.ic_bottom_nav_account
    )
}
