package com.zenika.tutorial.presentation.parchment.end_parchment

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.ui.theme.buttonPadding
import com.zenika.ui.theme.mapPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EndParchment(
    finishGame: () -> Unit
) {
    val text = listOf(
        R.string.end_parchment, R.string.end_parchment2
    )
    Box(
        Modifier
            .fillMaxSize()
            .padding()
            .paint(
                painterResource(id = R.mipmap.sea_background),
                contentScale = ContentScale.FillHeight
            )
    ) {
        HorizontalPager(pageCount = 3) { page ->
            Image(
                painter = painterResource(
                    id = R.mipmap.parchment
                ),
                contentDescription = "Treasure Map with a mysterious message",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (page == 0) {
                    Text(
                        text = stringResource(id = text[page]),
                        modifier = Modifier
                            .padding(
                                top = mapPadding,
                                start = mapPadding,
                                end = mapPadding
                            ),
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Image(
                        painter = painterResource(
                            id = R.mipmap.arrow
                        ),
                        contentDescription = "Arrow to swipe",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(70.dp)
                    )
                } else {
                    Text(
                        text = stringResource(id = text[page]),
                        modifier = Modifier.padding(
                            top = mapPadding,
                            start = mapPadding,
                            end = mapPadding,
                            bottom = buttonPadding
                        ),
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Button(onClick = finishGame) {
                        Text(
                            text = "Score",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

@ScreenPreview
@Composable
fun EndParchmentPreview() {
    ZEscapeThemePreview {
        EndParchment(
            finishGame = {}
        )
    }
}