package com.zenika.tutorial.presentation.parchment.welcome_parchment

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
import androidx.compose.ui.Alignment.Companion.Center
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
import com.zenika.ui.theme.topMapPadding
import com.zenika.ui.theme.tutorialBodyMedium
import com.zenika.utils.ComposablePreview
import com.zenika.utils.ZEscapeThemePreview
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeParchmentScreen(
    openInstruction: () -> Unit
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val text = listOf(
        R.string.welcome_parchment, R.string.welcome_parchment2, R.string.welcome_parchment3
    )
    Box(
        Modifier
            .fillMaxSize()
            .padding()
            .paint(
                painterResource(R.mipmap.background1),
                contentScale = ContentScale.Crop
            )
    ) {
        HorizontalPager(
            pageCount = 3,
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
                    .align(Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (page <= 1) {
                    Text(
                        text = stringResource(text[page]),
                        modifier = Modifier.padding(
                            top = topMapPadding,
                            start = mapPadding,
                            end = mapPadding
                        ),
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        style = tutorialBodyMedium
                    )
                    Image(
                        painter = painterResource(R.mipmap.arrow),
                        contentDescription = stringResource(R.string.arrow_image),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(70.dp)
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(page + 1)
                                }
                            }
                    )
                } else {
                    Text(
                        text = stringResource(text[page]),
                        modifier = Modifier.padding(
                            top = mapPadding,
                            start = mapPadding,
                            end = mapPadding,
                            bottom = buttonPadding
                        ),
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        style = tutorialBodyMedium
                    )
                    Button(onClick = openInstruction) {
                        Text(
                            text = stringResource(R.string.start_button),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

@ComposablePreview
@Composable
private fun WelcomeParchmentPreview() {
    ZEscapeThemePreview {
        WelcomeParchmentScreen(
            openInstruction = {}
        )
    }
}
