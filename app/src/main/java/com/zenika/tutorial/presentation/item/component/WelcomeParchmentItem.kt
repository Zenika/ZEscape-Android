package com.zenika.tutorial.presentation.item.component

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeParchmentItem(
    onDismissRequest: () -> Unit
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val text = listOf(
        R.string.welcome_parchment, R.string.welcome_parchment2, R.string.welcome_parchment3
    )
    HorizontalPager(
        pageCount = text.size,
        state = pagerState
    ) { page ->
        Image(
            painter = painterResource(
                id = R.mipmap.parchment
            ),
            contentDescription = stringResource(id = R.string.parchment_image),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            Modifier
                .fillMaxSize()
                .padding(top = topMapPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            IconButton(onClick = onDismissRequest) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = stringResource(R.string.close),
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (page <= 1) {
                Text(
                    text = stringResource(id = text[page]),
                    modifier = Modifier.padding(
                        top = topMapPadding,
                        start = mapPadding,
                        end = mapPadding
                    ),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium
                )
                Image(
                    painter = painterResource(
                        id = R.mipmap.arrow
                    ),
                    contentDescription = stringResource(id = R.string.arrow_image),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            coroutineScope.launch {
                                pagerState.scrollToPage(page + 1)
                            }
                        }
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
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@ScreenPreview
@Composable
fun WelcomeParchmentItemPreview() {
    ZEscapeThemePreview {
        WelcomeParchmentItem(
            onDismissRequest = {}
        )
    }
}
