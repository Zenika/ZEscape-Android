package com.zenika.tutorial.presentation.map.welcome_map

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.ui.theme.mapPadding
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun WelcomeMap(
    textId: Int,
    onClick: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding()
            .paint(
                painterResource(id = R.mipmap.sea_background),
                contentScale = ContentScale.FillHeight
            )
    ) {
        Image(
            painter = painterResource(
                id = R.mipmap.treasure_map
            ),
            contentDescription = "Treasure Map with a mysterious message",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() }
        )
        Text(
            text = stringResource(id = textId),
            modifier = Modifier
                .align(Center)
                .padding(
                    top = mapPadding,
                    start = mapPadding,
                    end = mapPadding
                ),
            textAlign = TextAlign.Center,
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@ComposablePreview
@Composable
fun WelcomeMapPreview() {
    ZEscapeThemePreview {
        WelcomeMap(
            textId = R.mipmap.paper,
            onClick = {}
        )
    }
}