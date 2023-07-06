package com.zenika.adventure.presentation.casablanca.game_room

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun GameRoomRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: GameRoomViewModel = hiltViewModel()
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    GameRoomScreen(
        remainingTime,
        goToSettings,
        openWorldMap,
        openInventory
    )
}