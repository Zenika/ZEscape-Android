package com.zenika.story.adventure.presentation.casablanca.offices

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CasablancaOfficesRoute(
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: CasablancaOfficesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CasablancaOfficesScreen(
        remainingTime = state.remainingTime,
        newItem = state.newItem,
        goBack = goBack,
        goToSettings = goToSettings,
        openWorldMap = openWorldMap,
        openInventory = openInventory
    )
}
