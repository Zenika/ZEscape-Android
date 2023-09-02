package com.zenika.adventure.presentation.casablanca.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CasablancaAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openAgencyMap: () -> Unit,
    goToSafe: () -> Unit,
    viewModel: CasablancaAgencyViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CasablancaAgencyScreen(
        state.remainingTime,
        state.newItem,
        state.isSafeOpened,
        state.isKeyCollected,
        goToSettings,
        openWorldMap,
        openInventory,
        openAgencyMap,
        goToSafe,
        viewModel::collectKey
    )
}

