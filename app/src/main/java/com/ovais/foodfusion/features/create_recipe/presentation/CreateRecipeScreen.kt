package com.ovais.foodfusion.features.create_recipe.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CreateRecipeScreen() {
    Surface(Modifier.fillMaxSize()) {
        Text(text = "Create Recipe")
    }
}