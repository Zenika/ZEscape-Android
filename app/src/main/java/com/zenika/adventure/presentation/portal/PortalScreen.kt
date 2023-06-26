package com.zenika.adventure.presentation.portal

import androidx.compose.runtime.Composable
import com.zenika.R
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun PortalScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    accessToPortal: () -> Unit,
    openWorldMap: () -> Unit
) {
    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        onClick = accessToPortal,
        openWorldMap = openWorldMap,
        background = R.mipmap.background_neon
    )
}

@ScreenPreview
@Composable
fun PortalScreenPreview() {
    ZEscapeThemePreview {
        PortalScreen(
            remainingTime = 60,
            goToSettings = {},
            accessToPortal = {},
            openWorldMap = {}
        )
    }
}