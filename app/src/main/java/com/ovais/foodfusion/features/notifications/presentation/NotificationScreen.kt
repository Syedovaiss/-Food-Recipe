package com.ovais.foodfusion.features.notifications.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NotificationScreen() {
    Surface(Modifier.fillMaxSize()) {
        Text(text = "Notifications")
    }
}