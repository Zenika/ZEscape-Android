package com.zenika.adventure.presentation.singapore.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SingaporeAgencyRoute(
    goToSettings: () -> Unit,
    openLaserGame: () -> Unit,
    openWorldMap: () -> Unit,
    viewModel: SingaporeAgencyViewModel = hiltViewModel(),
) {
    val remainingTime by viewModel.remainingTime.collectAsState()

    SingaporeAgencyScreen(
        remainingTime,
        goToSettings,
        openLaserGame,
        openWorldMap
    )
}

