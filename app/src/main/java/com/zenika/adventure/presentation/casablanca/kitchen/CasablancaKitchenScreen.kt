package com.zenika.adventure.presentation.casablanca.kitchen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zenika.R
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaKitchenScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    modifier: Modifier = Modifier
) {
    FlashlightScaffoldScreen(
        modifier = modifier,
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_kitchen,
        openWorldMap = openWorldMap,
        openInventory = openInventory
    )
}

@ScreenPreview
@Composable
private fun CasablancaKitchenScreenPreview() {
    ZEscapeThemePreview {
        CasablancaKitchenScreen(
            remainingTime = 3_600,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}
