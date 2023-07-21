package com.zenika.adventure.presentation.montreal.simon_says

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SimonSaysRoute(
    winGame: () -> Unit,
    goToSettings: () -> Unit,
    viewModel: SimonsSaysViewModel = hiltViewModel()
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                SimonsSaysGameEvent.WIN -> winGame()
            }
        }
    }

    SimonCase(
        goToSettings,
        remainingTime,
        state,
        viewModel::startGame,
        viewModel::onButtonClick
    )
}
