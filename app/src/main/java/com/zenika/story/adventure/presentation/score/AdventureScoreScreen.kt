package com.zenika.story.adventure.presentation.score

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.common.component.Timer
import com.zenika.story.adventure.domain.Statistics
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.textListSpacing

@Composable
fun AdventureScoreScreen(
    goBackToHome: () -> Unit,
    statistics: Statistics,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.mipmap.computer),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(textListSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.score),
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )
            Row {
                Text(
                    text = stringResource(R.string.time),
                    color = Color.White
                )
                Timer(
                    statistics.elapsedTime,
                    Modifier.padding(start = 4.dp),
                    Color.White
                )
            }
            Text(
                text = stringResource(R.string.hint_count, statistics.hint),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Text(
                text = stringResource(R.string.penalty_count, statistics.penalty),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Button(onClick = goBackToHome) {
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
private fun AdventureScoreScreenPreview() {
    ZEscapeThemePreview {
        AdventureScoreScreen(
            goBackToHome = {},
            statistics = Statistics(
                penalty = 0,
                hint = 0,
                elapsedTime = 0
            )
        )
    }
}
