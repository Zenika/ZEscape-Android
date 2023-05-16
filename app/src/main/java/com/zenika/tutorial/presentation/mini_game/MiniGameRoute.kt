package com.zenika.tutorial.presentation.mini_game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.tutorial.presentation.main.MainViewModel
import com.zenika.ui.theme.screenPadding

@Composable
fun MiniGameRoute(
    onDismissRequest: () -> Unit,
    gameViewModel: MiniGameViewModel = hiltViewModel(),
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val colors by gameViewModel.colorsSequence.collectAsState()
    val size by gameViewModel.sequenceSize.collectAsState()

    LaunchedEffect(gameViewModel) {
        gameViewModel.events.collect { event ->
            when(event) {
                MiniGameEvent.DISMISS -> onDismissRequest()
            }
        }
    }

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        MiniGameDialog(
            Modifier
                .fillMaxWidth()
                .padding(screenPadding)
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.shapes.extraLarge
                ),
            colors,
            size,
            gameViewModel::addColor,
            gameViewModel::checkSequence,
            gameViewModel::initColorsSequence,
            mainViewModel::updateChestState,
            onDismissRequest
        )
    }
}


