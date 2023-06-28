package com.zenika.adventure.presentation.portal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PortalRoute(
    goToSettings: () -> Unit,
    accessToClosePortal: () -> Unit,
    accessToOpenPortal: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: PortalViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    PortalScreen(
        state,
        goToSettings,
        accessToClosePortal,
        accessToOpenPortal,
        viewModel::finishGame,
        openWorldMap,
        openInventory
    )
}

