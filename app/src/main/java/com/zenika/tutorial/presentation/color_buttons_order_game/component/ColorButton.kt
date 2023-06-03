package com.zenika.tutorial.presentation.color_buttons_order_game.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun ColorButton(
    symbol: String,
    color: Color,
    colorName: String,
    addColor: (String) -> Unit
) {
    Text(
        text = symbol,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color)
            .wrapContentSize(Alignment.Center)
            .clickable(role = Role.Button) { addColor(colorName) }
    )
}


@ScreenPreview
@Composable
fun ColorButtonPreview() {
    ZEscapeThemePreview {
        ColorButton(
            symbol = "@",
            color = Color.Blue,
            colorName = "blue",
            addColor = {}
        )
    }
}
