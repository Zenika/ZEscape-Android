package com.zenika.adventure.presentation.casablanca.offices

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zenika.R
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaOfficesScreen(
    remainingTime: Int,
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    modifier: Modifier = Modifier
) {
    FlashlightScaffoldScreen(
        modifier = modifier,
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_offices,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        goBack = goBack
    )
}

@ScreenPreview
@Composable
private fun CasablancaOfficesScreenPreview() {
    ZEscapeThemePreview {
        CasablancaOfficesScreen(
            remainingTime = 3_600,
            goBack = {},
            goToSettings = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}
