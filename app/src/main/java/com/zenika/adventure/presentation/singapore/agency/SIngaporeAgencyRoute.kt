package com.zenika.adventure.presentation.singapore.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SingaporeAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: SingaporeAgencyViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifeCycle()

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

