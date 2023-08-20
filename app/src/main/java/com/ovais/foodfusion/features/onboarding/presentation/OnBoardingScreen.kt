package com.ovais.foodfusion.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ovais.foodfusion.R
import com.ovais.foodfusion.common.navigation.Screens
import com.ovais.foodfusion.common.ui.IconButton
import com.ovais.foodfusion.common.ui.LargeTitleComponent
import com.ovais.foodfusion.common.ui.NormalTextComponent


@Composable
fun OnBoarding(
    navController: NavController
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(
                id = R.drawable.onboarding
            ),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LargeTitleComponent(
                title = "Let's\n Cooking",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            NormalTextComponent(
                title = "Find best recipes for cooking",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            IconButton(
                title = "Start Cooking",
                rightDrawable = R.drawable.ic_arrow_right,
                fontSize = 18.sp
            ) {
                navController.navigate(Screens.BottomNavigationScreen.route)
            }
        }

    }

}