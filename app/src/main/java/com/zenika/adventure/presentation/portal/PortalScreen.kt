package com.zenika.adventure.presentation.portal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.adventure.presentation.component.InventoryBag
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun PortalScreen(
    state: PortalUiState,
    goToSettings: () -> Unit,
    accessToClosePortal: () -> Unit,
    accessToOpenPortal: () -> Unit,
    finishGame: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
) {
    val accessToPortal = if (state.collectSingaporeKey) {
        accessToOpenPortal
    } else {
        accessToClosePortal
    }

    ScaffoldScreen(
        modifier = Modifier.clickable {
            accessToPortal()
            if (state.collectSingaporeKey) {
                finishGame()
            }
        },
        remainingTime = state.remainingTime,
        goToSettings = goToSettings,
        onClick = accessToPortal,
        background = R.mipmap.background_neon
    ) {
        ContinentsMap(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.BottomStart)
                .clickable { openWorldMap() }
                .padding(screenPadding)
        )
        InventoryBag(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.BottomEnd)
                .clickable { openInventory() }
                .padding(screenPadding)
        )
    }
}

@ScreenPreview
@Composable
fun PortalScreenPreview() {
    ZEscapeThemePreview {
        PortalScreen(
            state = PortalUiState(
                collectSingaporeKey = false,
                remainingTime = 3600
            ),
            goToSettings = {},
            accessToClosePortal = {},
            accessToOpenPortal = {},
            finishGame = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}
