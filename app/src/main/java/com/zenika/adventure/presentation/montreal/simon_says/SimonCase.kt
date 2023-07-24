package com.zenika.adventure.presentation.montreal.simon_says

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun SimonCase(
    goToSettings: () -> Unit,
    remainingTime: Int,
    state: SimonState,
    startGame: () -> Unit,
    onButtonClick: (Char) -> Unit,
    modifier: Modifier = Modifier
) {
    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.montreal_outside
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .align(Center),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimonGrid(
                buttonsText = state.buttonsText,
                onButtonClick = onButtonClick,
                lightButton = state.lightButton,
                mode = state.mode
            )
            SimonIncentive(text = stringResource(state.indicationText))
            Button(onClick = startGame, enabled = state.systemSequence.size == 0) {
                Text(text = "GO")
            }
        }
    }
}

@Composable
private fun SimonIncentive(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier
            .padding(16.dp),
        style = MaterialTheme.typography.displaySmall
    )
}

@ScreenPreview
@Composable
private fun SimonCasePlayerPreview() {
    ZEscapeThemePreview {
        SimonCase(
            goToSettings = {},
            remainingTime = 3600,
            state = SimonState(
                mode = SimonGridMode.PLAYER,
                lightButton = null,
                buttonsText = ('A'..'P').toList(),
                systemSequence = mutableListOf(),
                playerSequence = mutableListOf(),
                indicationText = R.string.ready
            ),
            startGame = {},
            onButtonClick = { },
            modifier = Modifier
                .background(Color.White)
        )
    }
}

@ScreenPreview
@Composable
private fun SimonCaseSystemPreview() {
    ZEscapeThemePreview {
        SimonCase(
            goToSettings = {},
            remainingTime = 3600,
            state = SimonState(
                mode = SimonGridMode.SYSTEM,
                lightButton = null,
                buttonsText = listOf(),
                systemSequence = mutableListOf(),
                playerSequence = mutableListOf(),
                indicationText = R.string.ready
            ),
            startGame = {},
            onButtonClick = { },
            modifier = Modifier
                .background(Color.White)
        )
    }
}
