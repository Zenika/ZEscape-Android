package com.zenika.adventure.presentation.singapore.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SingaporeAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    viewModel: SingaporeAgencyViewModel = hiltViewModel(),
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    SingaporeAgencyScreen(
        remainingTime,
        goToSettings,
        openWorldMap
    )
}

