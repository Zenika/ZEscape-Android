package com.zenika.tutorial.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Code() {
    Row {
        Text(
            text = "@",
            color = Color.Blue,
            fontSize = 24.sp
        )
        Text(
            text = "#",
            color = Color.Green,
            fontSize = 24.sp
        )
        Text(
            text = "%",
            color = Color.Red,
            fontSize = 24.sp
        )
        Text(
            text = "&",
            color = Color.Yellow,
            fontSize = 24.sp
        )
    }
}

@ComposablePreview
@Composable
fun CodePreview() {
    ZEscapeThemePreview {
        Code()
    }
}