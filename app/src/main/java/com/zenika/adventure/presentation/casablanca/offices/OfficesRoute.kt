package com.zenika.adventure.presentation.casablanca.offices

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun OfficesRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: OfficesViewModel = hiltViewModel()
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    OfficesScreen(
        remainingTime,
        goToSettings,
        openWorldMap,
        openInventory
    )
}