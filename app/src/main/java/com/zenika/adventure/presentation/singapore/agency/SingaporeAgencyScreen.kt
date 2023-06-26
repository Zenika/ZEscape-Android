package com.zenika.adventure.presentation.singapore.agency

import androidx.compose.runtime.Composable
import com.zenika.R
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun SingaporeAgencyScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    openLaserGame: () -> Unit,
    openWorldMap: () -> Unit
) {
    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        onClick = openLaserGame,
        openWorldMap = openWorldMap,
        background = R.mipmap.singapore_agency
    )
}

@ScreenPreview
@Composable
fun SingaporeAgencyScreenPreview() {
    ZEscapeThemePreview {
        SingaporeAgencyScreen(
            remainingTime = 60,
            goToSettings = {},
            openLaserGame = {},
            openWorldMap = {}
        )
    }
}