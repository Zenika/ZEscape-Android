package com.zenika.adventure.presentation.casablanca.offices

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zenika.R
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.presentation.component.ReturnButton
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaOfficesScreen(
    remainingTime: Int,
    newItem: Boolean,
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    modifier: Modifier = Modifier
) {
    FlashlightScaffoldScreen(
        modifier = modifier,
        remainingTime = remainingTime,
        newItem = newItem,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_offices,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        navigationIcon = { ReturnButton(goBack = goBack) }
    )
}

@ScreenPreview
@Composable
private fun CasablancaOfficesScreenPreview() {
    ZEscapeThemePreview {
        CasablancaOfficesScreen(
            remainingTime = 3_600,
            newItem = false,
            goBack = {},
            goToSettings = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}
