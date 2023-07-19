package com.zenika.adventure.presentation.montreal.simon_says

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.ScaffoldScreen
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun SimonCase(
    goToSettings: () -> Unit,
    remainingTime: Int,
    startSimonSays: () -> Unit,
    buttonsText: List<Int>,
    onButtonClick: (Int) -> Unit,
    lightButton: Int?,
    mode: SimonGridMode,
    modifier: Modifier = Modifier
) {
    ScaffoldScreen(
        remainingTime = remainingTime,
        goToSettings = goToSettings,
        background = R.mipmap.singapore_outside
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
                .align(Center),
            horizontalAlignment = CenterHorizontally
        ) {
            SimonGrid(
                buttonsText = buttonsText,
                onButtonClick = onButtonClick,
                lightButton = lightButton,
                mode = mode
            )
            if (mode == SimonGridMode.PLAYER) {
                SimonIncentive(text = "A toi !")
            } else {
                SimonIncentive(text = "Écoute")
            }
            Button(onClick = startSimonSays, enabled = mode == SimonGridMode.SYSTEM) {
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

@Preview
@Composable
private fun SimonCasePlayerPreview() {
    ZEscapeThemePreview {
        SimonCase(
            goToSettings = {},
            remainingTime = 3600,
            startSimonSays = {},
            buttonsText = (1..16).toList(),
            onButtonClick = { },
            lightButton = null,
            mode = SimonGridMode.PLAYER,
            modifier = Modifier
                .background(Color.White)
        )
    }
}

@Preview
@Composable
private fun SimonCaseSystemPreview() {
    ZEscapeThemePreview {
        SimonCase(
            goToSettings = {},
            remainingTime = 3600,
            startSimonSays = {},
            buttonsText = (1..16).toList(),
            onButtonClick = { },
            lightButton = null,
            mode = SimonGridMode.SYSTEM,
            modifier = Modifier
                .background(Color.White)
        )
    }
}
