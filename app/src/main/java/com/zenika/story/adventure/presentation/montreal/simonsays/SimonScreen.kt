package com.zenika.story.adventure.presentation.montreal.simonsays

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
import com.zenika.story.adventure.domain.model.AdventureHint
import com.zenika.story.adventure.presentation.component.ScaffoldScreen
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Composable
fun SimonScreen(
    goToSettings: () -> Unit,
    remainingTime: Int,
    state: SimonState,
    openHintValidation: (AdventureHint) -> Unit,
    startGame: () -> Unit,
    onButtonClick: (Char) -> Unit,
    modifier: Modifier = Modifier
) {
    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        openHintValidation = { openHintValidation(AdventureHint.SIMON_SAYS_HINT) },
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
        SimonScreen(
            goToSettings = {},
            remainingTime = 3600,
            state = SimonState(
                mode = SimonGridMode.PLAYER,
                lightButton = null,
                buttonsText = ('A'..'P').toImmutableList(),
                systemSequence = mutableListOf(),
                playerSequence = mutableListOf(),
                indicationText = R.string.ready
            ),
            startGame = {},
            onButtonClick = {},
            openHintValidation = {},
            modifier = Modifier
                .background(Color.White)
        )
    }
}

@ScreenPreview
@Composable
private fun SimonCaseSystemPreview() {
    ZEscapeThemePreview {
        SimonScreen(
            goToSettings = {},
            remainingTime = 3600,
            state = SimonState(
                mode = SimonGridMode.SYSTEM,
                lightButton = null,
                buttonsText = persistentListOf(),
                systemSequence = mutableListOf(),
                playerSequence = mutableListOf(),
                indicationText = R.string.ready
            ),
            startGame = {},
            onButtonClick = {},
            openHintValidation = {},
            modifier = Modifier
                .background(Color.White)
        )
    }
}
