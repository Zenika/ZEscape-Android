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
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()
    val safeState by viewModel.safeState.collectAsStateWithLifecycle()

    CasablancaAgencyScreen(
        remainingTime,
        safeState,
        goToSettings,
        openWorldMap,
        openInventory,
        openAgencyMap,
        goToSafe,
        viewModel::collectKey
    )
}

