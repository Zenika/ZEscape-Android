package com.zenika.tutorial.presentation.color_buttons_order_game

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ColorButtonsOrderGameRoute(
    onDismissRequest: () -> Unit,
    openPenalty: (String) -> Unit,
    viewModel: ColorButtonsOrderGameViewModel = hiltViewModel()
) {
    val size by viewModel.sequenceSize.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                MiniGameEvent.DISMISS -> onDismissRequest()
                MiniGameEvent.PENALTY -> openPenalty("game")
            }
        }
    }
    ColorButtonsOrderGameDialog(
        size,
        onDismissRequest,
        viewModel::onColorClick
    )
}