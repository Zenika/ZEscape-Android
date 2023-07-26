package com.zenika.adventure.presentation.portal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import com.zenika.R
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zenika.adventure.presentation.component.AdventureInventoryBag
import com.zenika.adventure.presentation.component.ContinentsMap

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
                collectSingaporeKey = false,
                remainingTime = 0
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
