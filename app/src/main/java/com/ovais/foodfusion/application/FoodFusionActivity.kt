package com.ovais.foodfusion.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ovais.foodfusion.application.theme.FoodFusionTheme
import com.ovais.foodfusion.common.navigation.Navigation
import com.ovais.foodfusion.common.navigation.NavigationDataProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FoodFusionActivity : ComponentActivity() {

    @Inject
    lateinit var navigationDataProvider: NavigationDataProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodFusionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(dataProvider = navigationDataProvider).Navigate()
                }
            }
        }
    }
}