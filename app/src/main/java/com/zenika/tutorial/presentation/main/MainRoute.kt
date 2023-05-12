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
    val chestState by mainViewModel.chestState.collectAsState()
    val collectedMap by mainViewModel.collectedMap.collectAsState()
    MainScreen(
        Modifier.fillMaxSize(),
        chestState,
        collectedMap,
        openMiniGame,
        openInventory,
        mainViewModel::updateMapState
    )
}