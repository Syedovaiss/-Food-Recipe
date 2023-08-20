package com.ovais.foodfusion.features.home.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController
) {
    Surface(Modifier.fillMaxSize()) {
        Text(text = "Home")
    }
}