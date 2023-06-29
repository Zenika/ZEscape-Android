package com.zenika.adventure.presentation.casablanca.agency

import androidx.compose.runtime.Composable
import com.zenika.R
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaAgencyScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit
) {
    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        onClick = {},
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        background = R.mipmap.casablanca_agency,
        content = {}
    )
}

@ScreenPreview
@Composable
fun CasablancaAgencyScreenPreview() {
    ZEscapeThemePreview {
        CasablancaAgencyScreen(
            remainingTime = 60,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}