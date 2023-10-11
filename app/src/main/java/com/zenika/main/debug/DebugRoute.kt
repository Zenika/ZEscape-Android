package com.zenika.main.debug

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.ImmutableList

@Composable
fun DebugRoute(
    goBack: () -> Unit,
    games: ImmutableList<Pair<Game, () -> Unit>>,
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
