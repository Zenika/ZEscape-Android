package com.zenika.adventure.presentation.casablanca.gameroom

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zenika.R
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@RequiresApi(VERSION_CODES.M)
@Composable
fun CasablancaGameRoomScreen(
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
        background = R.mipmap.casablanca_game_room,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        goBack = goBack
    )
}

@RequiresApi(VERSION_CODES.M)
@ScreenPreview
@Composable
private fun CasablancaGameRoomScreenPreview() {
    ZEscapeThemePreview {
        CasablancaGameRoomScreen(
            remainingTime = 3_600,
            goBack = {},
            goToSettings = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}
