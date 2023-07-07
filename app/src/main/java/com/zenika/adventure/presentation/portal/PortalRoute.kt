package com.zenika.adventure.presentation.portal

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun PortalRoute(
    goToSettings: () -> Unit,
    accessToClosePortal: () -> Unit,
    accessToOpenPortal: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: PortalViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    BackHandler {
        // Player cannot leave the adventure while it is running.
    }

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

