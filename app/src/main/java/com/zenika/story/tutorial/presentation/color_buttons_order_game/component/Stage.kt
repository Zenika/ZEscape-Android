package com.zenika.story.tutorial.presentation.color_buttons_order_game.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun Stage(size: Int) {
    Text(
        text = "$size/4",
        style = MaterialTheme.typography.headlineMedium
    )
}

@ScreenPreview
@Composable
private fun StagePreview() {
    ZEscapeThemePreview {
        Stage(
            size = 2
        )
    }
}
