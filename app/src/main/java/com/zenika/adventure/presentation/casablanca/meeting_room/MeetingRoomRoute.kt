package com.zenika.adventure.presentation.casablanca.meeting_room

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.adventure.presentation.casablanca.offices.OfficesViewModel

@Composable
fun MeetingRoomRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: OfficesViewModel = hiltViewModel()
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    MeetingRoomScreen(
        remainingTime,
        goToSettings,
        openWorldMap,
        openInventory
    )
}