package com.zenika.adventure.presentation.score

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.domain.Statistics
import com.zenika.adventure.presentation.component.Timer
import com.zenika.ui.theme.textListSpacing
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun ScoreScreen(
    goToHome: () -> Unit,
    statistics: Statistics
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = painterResource(id = R.mipmap.computer),
                contentScale = ContentScale.FillHeight)
    ) {
        Column(
            modifier = Modifier
                .align(Center),
            verticalArrangement = Arrangement.spacedBy(textListSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.score),
                style = MaterialTheme.typography.headlineLarge
            )
            Row {
                Text(
                    text = stringResource(R.string.time)
                )
                Timer(
                    statistics.elapsedTime,
                    Modifier.padding(start = 4.dp)
                )
            }
            Text(
                text = stringResource(R.string.hint, statistics.hint),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = stringResource(R.string.penalty, statistics.penalty),
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
        ScoreScreen(
            goToHome = {},
            statistics = Statistics(
                penalty = 0,
                hint = 0,
                elapsedTime = 3600000
            )
        )
    }
}
