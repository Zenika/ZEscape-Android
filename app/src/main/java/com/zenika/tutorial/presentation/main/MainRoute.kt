package com.zenika.tutorial.presentation.main

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.data.state.GameState

@Composable
fun MainRoute(
    openMiniGame: () -> Unit,
    openInventory: () -> Unit,
    mainViewModel: MainViewModel = hiltViewModel(),
    gameState: GameState = GameState()
) {
    val chestOpened by gameState.chestOpened.collectAsState()
    val mapCollected by gameState.mapCollected.collectAsState()

    Log.d("chest state", chestOpened.toString())
    Log.d("map state", mapCollected.toString())

    MainScreen(
        Modifier.fillMaxSize(),
        chestOpened,
        mapCollected,
        openMiniGame,
        openInventory,
        mainViewModel::updateMapState
    )
}