package com.zenika.adventure.presentation.singapore.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SingaporeAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: SingaporeAgencyViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    SingaporeAgencyScreen(
        state,
        goToSettings,
        openWorldMap,
        openInventory,
        viewModel::collectKey,
        viewModel::collectSword,
        viewModel::collectHook
    )
}

