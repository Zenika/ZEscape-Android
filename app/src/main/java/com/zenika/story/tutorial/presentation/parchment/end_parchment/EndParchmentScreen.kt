package com.zenika.story.tutorial.presentation.parchment.end_parchment

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.buttonPadding
import com.zenika.theme.mapPadding
import com.zenika.theme.tutorialBodyMedium
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EndParchmentScreen(
    goToScore: () -> Unit
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val text = listOf(
        R.string.end_parchment,
        R.string.end_parchment2
    )
    Box(
        Modifier
            .fillMaxSize()
            .padding()
            .paint(
                painterResource(R.mipmap.background_tutorial),
                contentScale = ContentScale.Crop
            )
    ) {
        HorizontalPager(
            pageCount = 2,
            state = pagerState
        ) { page ->
            Image(
                painter = painterResource(R.mipmap.parchment),
                contentDescription = stringResource(R.string.parchment_image),
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
                Text(
                    text = stringResource(text[page]),
                    modifier = Modifier.padding(
                        top = mapPadding,
                        start = mapPadding,
                        end = mapPadding
                    ),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    style = tutorialBodyMedium
                )
                if (page == text.size - 1) {
                    Button(
                        modifier = Modifier.padding(top = buttonPadding),
                        onClick = goToScore
                    ) {
                        Text(
                            text = stringResource(R.string.score),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                } else {
                    Image(
                        painter = painterResource(R.mipmap.arrow),
                        contentDescription = stringResource(R.string.arrow_image, page + 1),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(70.dp)
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(1)
                                }
                            }
                    )
                }
            }
        }
    }
}

@ScreenPreview
@Composable
private fun EndParchmentPreview() {
    ZEscapeThemePreview {
        EndParchmentScreen(
            goToScore = {}
        )
    }
}
