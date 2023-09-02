package com.zenika.tutorial.presentation.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainRoute(
    goToSettings: () -> Unit,
    openMiniGame: () -> Unit,
    openInventory: () -> Unit,
    showHint: () -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    BackHandler {
        // Player cannot leave the tutorial while it is running.
    }

    val mainUiState by viewModel.state.collectAsStateWithLifecycle()
    val event by viewModel.event.collectAsStateWithLifecycle()

    LaunchedEffect(event) {
        when (event) {
            MainEvent.OPEN_INVENTORY -> openInventory()
            MainEvent.SHOW_HINT -> showHint()
            MainEvent.NONE -> Unit
        }
        viewModel.onEventHandled()
    }

    MainScreen(
        Modifier.fillMaxSize(),
        mainUiState,
        goToSettings,
        openMiniGame,
        openInventory = viewModel::openInventory,
        showHint = viewModel::showHint,
        collectKey = viewModel::collectKey,
        collectMap = viewModel::collectMap
    )
}
