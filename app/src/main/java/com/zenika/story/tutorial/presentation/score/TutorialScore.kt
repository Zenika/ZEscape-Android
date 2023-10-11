package com.zenika.story.tutorial.presentation.score

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.common.component.Timer
import com.zenika.story.tutorial.domain.Statistics
import com.zenika.story.tutorial.presentation.component.Parchment
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.textListSpacing

@Composable
fun TutorialScore(
    goToHome: () -> Unit,
    statistics: Statistics
) {
    Parchment {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(textListSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.score),
                style = MaterialTheme.typography.headlineLarge
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = stringResource(R.string.time))
                Timer(statistics.elapsedTime)
            }
            Text(
                text = stringResource(R.string.hint_count, statistics.hint),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = stringResource(R.string.penalty_count, statistics.penalty),
                style = MaterialTheme.typography.bodyMedium
            )
            Button(onClick = goToHome) {
                Text(
                    text = stringResource(R.string.home),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@ScreenPreview
@Composable
private fun TutorialScorePreview() {
    ZEscapeThemePreview {
        TutorialScore(
            goToHome = {},
            statistics = Statistics(
                penalty = 0,
                hint = 0,
                elapsedTime = 3600000
            )
        )
    }
}
