package com.zenika.story.tutorial.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.textListSpacing

@Composable
fun Parchment(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .paint(
                painterResource(R.mipmap.background_tutorial),
                contentScale = ContentScale.Crop
            )
            .paint(
                painterResource(R.mipmap.parchment),
                contentScale = ContentScale.Fit
            )
            .padding(64.dp)
    ) {
        CompositionLocalProvider(LocalContentColor provides Color.Black) {
            content()
        }
    }
}

@ScreenPreview
@Composable
private fun ParchmentPreview() {
    ZEscapeThemePreview {
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
            }
        }
    }
}
