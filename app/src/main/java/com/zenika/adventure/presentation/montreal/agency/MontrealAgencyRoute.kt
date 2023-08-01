package com.zenika.adventure.presentation.montreal.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MontrealAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    goToScan: () -> Unit,
    viewModel: MontrealAgencyViewModel = hiltViewModel(),
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    MontrealAgencyScreen(
        remainingTime,
        goToSettings,
        openWorldMap,
        openInventory,
        goToScan
    )
}
