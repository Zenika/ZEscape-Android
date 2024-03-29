package com.zenika.story.adventure.presentation.montreal.simonsays

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.story.adventure.domain.model.AdventureHint

@Composable
fun SimonSaysRoute(
    winGame: () -> Unit,
    goToSettings: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
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

    SimonScreen(
        goToSettings,
        remainingTime,
        state,
        openHintValidation,
        viewModel::startGame,
        viewModel::onButtonClick
    )
}
