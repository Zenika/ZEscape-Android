package com.zenika.tutorial.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.ui.theme.buttonPadding
import com.zenika.ui.theme.screenPadding
import com.zenika.ui.theme.tutorialBodyLarge
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    backToHome: () -> Unit,
    goToScan: () -> Unit,
    finishGame: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.home),
                        Modifier
                            .fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        backToHome()
                        finishGame()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .paint(
                    painterResource(id = R.mipmap.background1),
                    contentScale = ContentScale.FillHeight,
                    alpha = 0.4F
                ),
            verticalArrangement = Arrangement.spacedBy(
                buttonPadding,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.tutorial_home_text),
                modifier = Modifier.padding(screenPadding),
                textAlign = TextAlign.Center,
                style = tutorialBodyLarge
            )
            Button(onClick = goToScan) {
                Text(
                    text = stringResource(R.string.scan),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@ScreenPreview
@Composable
fun HomeScreenPreview() {
    ZEscapeThemePreview {
        HomeScreen(
            backToHome = {},
            goToScan = {},
            finishGame = {}
        )
    }
}
