package com.ovais.foodfusion.features.home.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ovais.foodfusion.R
import com.ovais.foodfusion.common.ui.NormalTextComponent

@Composable
fun CategoryItem(
    uiData: CategoriesUiData,
    onClick: (CategoriesUiData) -> Unit
) {
    Column(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp)
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .clickable {
                onClick(uiData)
            }
    ) {
        AsyncImage(
            model = uiData.thumbnail,
            contentDescription = "Category Thumbnail",
            placeholder = painterResource(id = R.drawable.placeholder),
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            alignment = Alignment.Center
        )
        NormalTextComponent(
            title = uiData.title,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            textColor = Color.Black
        )
    }
}

@Preview
@Composable
fun CateogoryItemPreview() {
    val uiData = CategoriesUiData(
        title = "Beef",
        thumbnail = "https://www.google.com.pk/"
    )
    CategoryItem(uiData = uiData)
}