package com.ovais.foodfusion.common.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ovais.foodfusion.R
import com.ovais.foodfusion.application.theme.BUTTON_RED


@Composable
fun IconButton(
    title: String,
    buttonBackground: Color = BUTTON_RED,
    rightDrawable: Int,
    textColor: Color = Color.White,
    fontSize: TextUnit,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .wrapContentSize()
            .background(buttonBackground, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            color = textColor,
            fontSize = fontSize
        )
        Image(
            painter = painterResource(
                id = rightDrawable
            ),
            contentDescription = "Right Arrow",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(horizontal = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIconButton() {
    IconButton(
        title = "Start Cooking",
        rightDrawable = R.drawable.ic_arrow_right,
        fontSize = 18.sp
    ) {

    }
}