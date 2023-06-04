package com.zenika.game.colorbuttons.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Stage(size: Int) {
    Text(
        text = "$size/4",
        style = MaterialTheme.typography.headlineMedium
    )
}

@Preview
@Composable
fun StagePreview() {
    Stage(
        size = 2
    )
}
