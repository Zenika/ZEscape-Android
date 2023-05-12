package com.zenika.tutorial.presentation.mini_game.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Stage(size: Int) {
    Text(
        text = "$size/4",
        style = MaterialTheme.typography.headlineMedium
    )
}

@ScreenPreview
@Composable
fun StagePreview() {
    ZEscapeThemePreview {
        Stage(
            size = 2
        )
    }
}
