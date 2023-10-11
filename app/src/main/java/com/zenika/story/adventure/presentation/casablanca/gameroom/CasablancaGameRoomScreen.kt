package com.zenika.story.adventure.presentation.casablanca.gameroom

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zenika.R
import com.zenika.common.component.ReturnButton
import com.zenika.story.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview

@Composable
fun CasablancaGameRoomScreen(
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
        newItem = newItem,
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.casablanca_game_room,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        navigationIcon = { ReturnButton(goBack = goBack) }
    )
}

@ScreenPreview
@Composable
private fun CasablancaGameRoomScreenPreview() {
    ZEscapeThemePreview {
        CasablancaGameRoomScreen(
            remainingTime = 3_600,
            newItem = false,
            goBack = {},
            goToSettings = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}
