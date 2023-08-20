package com.ovais.foodfusion.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ovais.foodfusion.R
import com.ovais.foodfusion.common.ui.LargeTitleComponent
import com.ovais.foodfusion.common.ui.NormalTextComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    var searchedText by remember { mutableStateOf("") }
    Surface(Modifier.fillMaxSize()) {
        Column {
            LargeTitleComponent(
                title = "Find best recipes\nfor cooking",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(top = 16.dp),
                textColor = Color.Black,
                textAlign = TextAlign.Left,
                fontSize = 24.sp
            )
            OutlinedTextField(
                value = searchedText,
                placeholder = {
                    Text(text = "Search Recipes")
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search Bar Icon",
                    )
                },
                onValueChange = { text ->
                    searchedText = text
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        viewModel.onSearchRecipe(query = searchedText)
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                NormalTextComponent(
                    title = "Trending Now",
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                    textColor = Color.Black,
                    textAlign = TextAlign.Left
                )
                NormalTextComponent(
                    title = "See All",
                    modifier = Modifier.padding(end = 16.dp, top = 16.dp),
                    textColor = Color.Red,
                    textAlign = TextAlign.End
                )
            }

        }
    }
}