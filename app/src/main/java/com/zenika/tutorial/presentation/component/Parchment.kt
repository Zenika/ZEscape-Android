package com.zenika.tutorial.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun Parchment(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.mipmap.background1),
                contentScale = ContentScale.FillHeight
            )
            .paint(
                painterResource(id = R.mipmap.parchment),
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
            Text(text = stringResource(R.string.welcome_parchment))
        }
    }
}
