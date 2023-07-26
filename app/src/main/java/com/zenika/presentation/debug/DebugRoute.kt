package com.zenika.presentation.debug

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.data.Game

@Composable
fun DebugRoute(
    goBack: () -> Unit,
    games: List<Pair<Game, () -> Unit>>,
    viewModel: DebugViewModel = hiltViewModel()
) {
    BackHandler {
        viewModel.goBack()
    }

    val event by viewModel.events.collectAsStateWithLifecycle(initialValue = null)
    LaunchedEffect(event) {
        when (event) {
            DebugEvent.HOME -> goBack()
            null -> Unit
        }
    }

    DebugScreen(
        viewModel::goBack,
        viewModel::initGameState,
        games,
    )
}
