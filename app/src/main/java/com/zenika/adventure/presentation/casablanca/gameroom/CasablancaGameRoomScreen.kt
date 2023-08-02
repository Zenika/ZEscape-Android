package com.zenika.adventure.presentation.casablanca.gameroom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.adventure.presentation.component.AdventureInventoryBag
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaGameRoomScreen(
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
        background = R.mipmap.casablanca_game_room,
        openWorldMap = openWorldMap,
        openInventory = openInventory
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(screenPadding),
        contentAlignment = Alignment.Center
    ) {
        ContinentsMap(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .clickable { openWorldMap() }
        )
        AdventureInventoryBag(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomEnd)
                .clickable { openInventory() }
        )
    }
}

@ScreenPreview
@Composable
private fun CasablancaGameRoomScreenPreview() {
    ZEscapeThemePreview {
        CasablancaGameRoomScreen(
            remainingTime = 3_600,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}
