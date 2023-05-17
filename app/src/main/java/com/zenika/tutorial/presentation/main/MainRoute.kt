package com.zenika.tutorial.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zenika.tutorial.SharedViewModel

@Composable
fun MainRoute(
    openMiniGame: () -> Unit,
    openInventory: () -> Unit,
    sharedViewModel: SharedViewModel = viewModel(),
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val gameState by sharedViewModel.gameState.collectAsState()

    MainScreen(
        Modifier.fillMaxSize(),
        gameState,
        openMiniGame,
        openInventory,
        mainViewModel::updateMapState
    )
}