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
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val gameUIState by mainViewModel.state.collectAsState()

    MainScreen(
        Modifier.fillMaxSize(),
        gameUIState,
        openMiniGame,
        openInventory,
        mainViewModel::collectMap
    )
}