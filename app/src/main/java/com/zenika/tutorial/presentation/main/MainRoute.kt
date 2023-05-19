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
    val chestOpened by mainViewModel.chestOpened.collectAsState()
    val mapCollected by mainViewModel.mapCollected.collectAsState()

    MainScreen(
        Modifier.fillMaxSize(),
        chestOpened,
        mapCollected,
        openMiniGame,
        openInventory,
        mainViewModel::updateMapState
    )
}