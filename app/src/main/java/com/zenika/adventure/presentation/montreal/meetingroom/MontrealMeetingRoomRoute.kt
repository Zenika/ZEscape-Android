package com.zenika.adventure.presentation.montreal.meetingroom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MontrealMeetingRoomRoute(
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openCode: () -> Unit,
    goToOffice: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: MontrealMeetingRoomViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                MeetingRoomEvent.OPEN_CODE -> openCode()
                MeetingRoomEvent.GO_TO_OFFICE -> goToOffice()
            }
        }
    }

    MontrealMeetingRoomScreen(
        state,
        goBack,
        goToSettings,
        viewModel::onButtonClick,
        openWorldMap,
        openInventory,
        viewModel::removeNewItemBadge
    )
}
