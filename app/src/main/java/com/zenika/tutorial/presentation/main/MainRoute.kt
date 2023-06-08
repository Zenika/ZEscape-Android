package com.zenika.tutorial.presentation.main

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
    val gameUIState by viewModel.state.collectAsState()

    MainScreen(
        Modifier.fillMaxSize(),
        gameUIState,
        openMiniGame,
        openInventory,
        showClue,
        viewModel::collectKey,
        viewModel::collectMap,
        viewModel::removeNewItemBadge,
        viewModel::incrementClueCount
    )
}