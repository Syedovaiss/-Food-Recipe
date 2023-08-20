package com.ovais.foodfusion.features.bottomnavigation

import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.ovais.foodfusion.R
import com.ovais.foodfusion.application.theme.BOTTOM_NAV_BACKGROUND
import com.ovais.foodfusion.features.accounts.presentation.AccountsScreen
import com.ovais.foodfusion.features.create_recipe.presentation.CreateRecipeScreen
import com.ovais.foodfusion.features.home.presentation.HomeScreen
import com.ovais.foodfusion.features.notifications.presentation.NotificationScreen
import com.ovais.foodfusion.features.saved_recipes.presentation.SavedRecipesScreen


@Composable
fun BottomNavigationScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { AnimatedBottomNav(navController = navController) }
    ) { contentPadding ->
        NavigationGraph(navController = navController)
    }
}

@Composable
fun AnimatedBottomNav(
    navController: NavController
) {
    val selectedIndex = remember {
        mutableStateOf(0)
    }
    val items = listOf(
        BottomNavigationItems.Home,
        BottomNavigationItems.SavedRecipes,
        BottomNavigationItems.CreateRecipe,
        BottomNavigationItems.Notifications,
        BottomNavigationItems.Account
    )
    AnimatedNavigationBar(
        selectedIndex = selectedIndex.value,
        modifier = Modifier.height(64.dp),
        ballColor = Color.Red,
        barColor = BOTTOM_NAV_BACKGROUND,
        cornerRadius = shapeCornerRadius(16.dp)
    ) {
        items.forEach { navItems ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .nonRippleClickable(navItems) { item ->
                        selectedIndex.value = item.index
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(id = navItems.icon),
                    contentDescription = navItems.title,
                    modifier = Modifier.size(26.dp)
                )
            }

        }
    }

}

@Deprecated(
    message = "Using Animated Bottom Nav"
)
@Composable
fun BottomNav(navController: NavController) {
    val items = listOf(
        BottomNavigationItems.Home,
        BottomNavigationItems.SavedRecipes,
        BottomNavigationItems.CreateRecipe,
        BottomNavigationItems.Notifications,
        BottomNavigationItems.Account
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavigationItems.Home.route) {
        composable(BottomNavigationItems.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(BottomNavigationItems.SavedRecipes.route) {
            SavedRecipesScreen()
        }
        composable(BottomNavigationItems.CreateRecipe.route) {
            CreateRecipeScreen()
        }
        composable(BottomNavigationItems.Notifications.route) {
            NotificationScreen()
        }
        composable(BottomNavigationItems.Account.route) {
            AccountsScreen()
        }
    }
}

fun Modifier.nonRippleClickable(
    navItem: BottomNavigationItems,
    onClick: (BottomNavigationItems) -> Unit
): Modifier =
    composed {
        clickable(
            indication = null,
            interactionSource = remember {
                MutableInteractionSource()
            }
        ) {
            onClick(navItem)
        }
    }