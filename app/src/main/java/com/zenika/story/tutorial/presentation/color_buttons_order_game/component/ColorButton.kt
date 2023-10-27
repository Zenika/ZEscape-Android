package com.zenika.story.tutorial.presentation.color_buttons_order_game.component

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
import com.zenika.theme.ComposablePreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun ColorButton(
    symbol: String,
    color: Color,
    colorName: String,
    onColorClick: (String) -> Unit
) {
    Text(
        text = symbol,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color)
            .wrapContentSize(Alignment.Center)
            .clickable(role = Role.Button) { onColorClick(colorName) }
    )
}


@ComposablePreview
@Composable
private fun ColorButtonPreview() {
    ZEscapeThemePreview {
        ColorButton(
            symbol = "@",
            color = Color.Blue,
            colorName = "blue",
            onColorClick = {}
        )
    }
}
