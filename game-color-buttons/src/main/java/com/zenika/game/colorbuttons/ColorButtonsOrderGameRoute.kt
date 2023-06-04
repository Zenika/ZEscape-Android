package com.zenika.game.colorbuttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ColorButtonsOrderGameRoute(
    onDismissRequest: () -> Unit,
    gameViewModel: ColorButtonsOrderGameViewModel = hiltViewModel()
) {
    val size by gameViewModel.sequenceSize.collectAsState()

    LaunchedEffect(gameViewModel) {
        gameViewModel.events.collect { event ->
            when (event) {
                MiniGameEvent.DISMISS -> onDismissRequest()
            }
        }
    }

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        ColorButtonsOrderGameDialog(
            Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.primaryContainer,
                    MaterialTheme.shapes.extraLarge
                ),
            size,
            gameViewModel::addColor,
            listOf(
                CharAndColor('#', Color(0xFF4CAF50)),
                CharAndColor('&', Color(0xFF9727B0)),
                CharAndColor('%', Color(0xFFF44336)),
                CharAndColor('@', Color(0xFF2196F3)),
            )
        )
    }
}

