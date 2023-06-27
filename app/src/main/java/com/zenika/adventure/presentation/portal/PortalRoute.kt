package com.zenika.adventure.presentation.portal

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun PortalRoute(
    goToSettings: () -> Unit,
    accessToPortal: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: PortalViewModel = hiltViewModel(),
) {
    BackHandler {
        // Player cannot leave the adventure while it is running.
    }

    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()
    
    PortalScreen(
        remainingTime,
        goToSettings,
        accessToPortal,
        openWorldMap,
        openInventory
    )
}

