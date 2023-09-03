package com.zenika.adventure.presentation.montreal.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.data.AdventureHint

@Composable
fun MontrealAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    goToScan: (String) -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    viewModel: MontrealAgencyViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MontrealAgencyScreen(
        remainingTime = state.remainingTime,
        newItem = state.newItem,
        isRooftopDiscovered = state.isRooftopDiscovered,
        isOfficeDiscovered = state.isOfficeDiscovered,
        goToSettings = goToSettings,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        goToScan = goToScan,
        openHintValidation = openHintValidation
    )
}
