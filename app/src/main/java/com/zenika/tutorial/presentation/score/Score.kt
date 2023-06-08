package com.zenika.tutorial.presentation.score

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.tutorial.presentation.component.Parchment
import com.zenika.ui.theme.textListSpacing
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Score(
    goToHome: () -> Unit,
    penalty: Int,
    clue: Int,
    finalTimer: Int
) {
    val elapsedTime = 3600000 - finalTimer
    val minutes = elapsedTime / 60000
    val seconds = elapsedTime / 1000 % 60
    val secondsString = if (seconds in 0..9) {
        "0$seconds"
    } else {
        seconds.toString()
    }

    val timer = "$minutes:$secondsString"

    Parchment {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(textListSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.score),
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = stringResource(R.string.time, timer),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(R.string.clue, clue),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = stringResource(R.string.penalty, penalty),
                style = MaterialTheme.typography.bodyMedium
            )
            Button(onClick = goToHome) {
                Text(
                    text = stringResource(id = R.string.home),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@ScreenPreview
@Composable
fun ScorePreview() {
    ZEscapeThemePreview {
        Score(
            goToHome = {},
            penalty = 0,
            clue = 0,
            finalTimer = 3500000
        )
    }
}
