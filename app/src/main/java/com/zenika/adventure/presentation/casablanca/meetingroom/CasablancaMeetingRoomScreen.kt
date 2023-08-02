package com.zenika.adventure.presentation.casablanca.meetingroom

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zenika.R
import com.zenika.adventure.presentation.casablanca.component.FlashlightScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun CasablancaMeetingRoomScreen(
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
        background = R.mipmap.casablanca_meeting_room,
        openWorldMap = openWorldMap,
        openInventory = openInventory
    )
}

@ScreenPreview
@Composable
private fun CasablancaMeetingRoomScreenPreview() {
    ZEscapeThemePreview {
        CasablancaMeetingRoomScreen(
            remainingTime = 3_600,
            goToSettings = {},
            openWorldMap = {},
            openInventory = {}
        )
    }
}
