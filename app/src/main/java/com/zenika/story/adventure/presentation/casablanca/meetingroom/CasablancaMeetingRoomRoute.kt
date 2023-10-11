package com.zenika.story.adventure.presentation.casablanca.meetingroom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CasablancaMeetingRoomRoute(
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: CasablancaMeetingRoomViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CasablancaMeetingRoomScreen(
        state,
        goBack,
        goToSettings,
        openWorldMap,
        openInventory,
        viewModel::collectPaper
    )
}

