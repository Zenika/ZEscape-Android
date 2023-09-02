package com.zenika.adventure.presentation.portal

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.data.AdventureHint

@Composable
fun PortalRoute(
    goToSettings: () -> Unit,
    accessToClosePortal: () -> Unit,
    onGameFinished: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    viewModel: PortalViewModel = hiltViewModel(),
) {
    BackHandler {
        // Player cannot leave the adventure while it is running.
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                PortalEvent.SHOW_CLOSED_PORTAL -> accessToClosePortal()
                PortalEvent.FINISH_GAME -> onGameFinished()
            }
        }
    }

    PortalScreen(
        state,
        goToSettings,
        viewModel::onPortalClick,
        openWorldMap,
        openInventory,
        openHintValidation
    )
}

