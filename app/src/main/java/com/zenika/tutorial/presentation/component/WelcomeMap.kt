package com.zenika.tutorial.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.tutorial.presentation.MapViewModel
import com.zenika.ui.theme.mapPadding
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun WelcomeMap(
    viewModel: MapViewModel,
    openInstruction: () -> Unit
) {
    val firstMapVisible by viewModel.welcomeMap1Visible.collectAsState()
    val secondMapVisible by viewModel.welcomeMap2Visible.collectAsState()

    if (firstMapVisible) {
        MapContent(R.string.welcome_map) { viewModel.hideWelcomeFirstMap() }
    } else if (secondMapVisible) {
        MapContent(R.string.welcome_map2) { viewModel.hideWelcomeSecondMap() }
    } else {
        MapContent(R.string.welcome_map3) { openInstruction() }
    }
}

@Composable
private fun MapContent(textId: Int, onClick: () -> Unit) {
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
            viewModel = MapViewModel(),
            openInstruction = {}
        )
    }
}