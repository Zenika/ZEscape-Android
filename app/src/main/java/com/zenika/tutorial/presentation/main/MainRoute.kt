package com.zenika.tutorial.presentation.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainRoute(
    openMiniGame: () -> Unit,
    openInventory: () -> Unit,
    showHint: () -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    val mainUiState by viewModel.state.collectAsStateWithLifecycle()

    BackHandler {
        // Player cannot leave the tutorial while it is running.
    }

    MainScreen(
        Modifier.fillMaxSize(),
        mainUiState,
        openMiniGame,
        openInventory,
        showHint,
        viewModel::collectKey,
        viewModel::collectMap,
        viewModel::removeNewItemBadge,
        viewModel::incrementHintCount
    )
}
