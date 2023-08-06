package com.ovais.foodfusion.common.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun NormalTextComponent(
    title: String,
    textColor: Color = Color.White,
    modifier: Modifier,
    textAlign: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 18.sp
) {
    Text(
        text = title,
        color = textColor,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Normal,
        modifier = modifier,
        textAlign = textAlign,
        fontSize = fontSize
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewNormalTextComponent() {
    NormalTextComponent(
        title = "Find best recipes for cooking",
        modifier = Modifier.fillMaxWidth()
    )
}