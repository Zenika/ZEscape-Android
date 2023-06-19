package com.zenika.tutorial.presentation.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainRoute(
    openMiniGame: () -> Unit,
    openInventory: () -> Unit,
    showClue: () -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    val mainUiState by viewModel.state.collectAsState()

    BackHandler {
        // Player cannot leave the tutorial while it is running.
    }

    MainScreen(
        Modifier.fillMaxSize(),
        mainUiState,
        openMiniGame,
        openInventory,
        showClue,
        viewModel::collectKey,
        viewModel::collectMap,
        viewModel::removeNewItemBadge,
        viewModel::incrementClueCount
    )
}
