package com.zenika.adventure.presentation.singapore.on_off_game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OnOffRoute(
    winGame: () -> Unit,
    goToSettings: () -> Unit,
    viewModel: OnOffViewModel = hiltViewModel()
) {
    val buttonsList = remember {
        viewModel.buttonsList
    }
    val remainingTime by viewModel.remainingTime.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                OnOffGameEvent.WIN -> winGame()
            }
        }
    }

    OnOffScreen(
        goToSettings,
        remainingTime,
        buttonsList,
        viewModel::switchColor
    )
}