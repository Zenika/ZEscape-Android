package com.zenika.adventure.presentation.casablanca.meetingroom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CasablancaMeetingRoomRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: CasablancaMeetingRoomViewModel = hiltViewModel()
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    CasablancaMeetingRoomScreen(
        remainingTime,
        goToSettings,
        openWorldMap,
        openInventory
    )
}
