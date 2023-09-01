package com.zenika.adventure.presentation.portal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.AdventureInventoryBag
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun PortalScreen(
    state: PortalUiState,
    goToSettings: () -> Unit,
    onPortalClick: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
) {
    ScaffoldScreen(
        modifier = Modifier.clickable(onClick = onPortalClick),
        remainingTime = state.remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.background_neon
    ) {
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable(onClick = openWorldMap)
        )
        AdventureInventoryBag(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
                .clickable(onClick = openInventory)
        )
    }
}

@ScreenPreview
@Composable
private fun PortalScreenPreview() {
    ZEscapeThemePreview {
        PortalScreen(
            state = PortalUiState(
                portalCanBeOpened = false,
                remainingTime = 0
            ),
            goToSettings = {},
            onPortalClick = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}
