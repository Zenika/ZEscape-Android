package com.zenika.adventure.presentation.casablanca.meetingroom

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@RequiresApi(Build.VERSION_CODES.M)
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

