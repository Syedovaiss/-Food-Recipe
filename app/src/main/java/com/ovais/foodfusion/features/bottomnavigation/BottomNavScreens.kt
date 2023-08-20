package com.ovais.foodfusion.features.bottomnavigation

sealed class BottomNavScreens(val route: String) {
    object HomeScreen: BottomNavScreens("home")
    object SavedRecipesScreen: BottomNavScreens("saved_recipes")
    object AddRecipesScreen: BottomNavScreens("add_recipe")
    object NotificationsScreen: BottomNavScreens("notification")
    object AccountsScreen: BottomNavScreens("accounts")
}
