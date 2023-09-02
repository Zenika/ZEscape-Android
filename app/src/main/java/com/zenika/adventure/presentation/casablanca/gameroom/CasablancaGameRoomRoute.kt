package com.zenika.adventure.presentation.casablanca.gameroom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CasablancaGameRoomRoute(
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: CasablancaGameRoomViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CasablancaGameRoomScreen(
        remainingTime = state.remainingTime,
        newItem = state.newItem,
        goBack = goBack,
        goToSettings = goToSettings,
        openWorldMap = openWorldMap,
        openInventory = openInventory
    )
}
