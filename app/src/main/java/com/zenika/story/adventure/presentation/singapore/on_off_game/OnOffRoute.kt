package com.zenika.story.adventure.presentation.singapore.on_off_game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.story.adventure.domain.model.AdventureHint

@Composable
fun OnOffRoute(
    winGame: () -> Unit,
    goToSettings: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    viewModel: OnOffViewModel = hiltViewModel()
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                OnOffGameEvent.WIN -> winGame()
            }
        }
    }

    OnOffScreen(
        goToSettings,
        openHintValidation,
        remainingTime,
        state.buttonsList,
        viewModel::switchColor
    )
}

