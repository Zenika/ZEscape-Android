package com.zenika.feature2.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Feature2Screen() {
    Text("Feature2")
}

@Preview
@Composable
fun Feature2ScreenPreview() {
    ZEscapeThemePreview {
        Feature2Screen()
    }
}
