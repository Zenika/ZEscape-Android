package com.zenika.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.zenika.R
import com.zenika.ui.theme.buttonPadding
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    goToTutorial: () -> Unit,
    goToAdventure: () -> Unit,
    goToDebug: () -> Unit,
    goToCredit: () -> Unit
) {
    var tapCount by remember {
        mutableStateOf(0)
    }
    val interactionSource = remember { MutableInteractionSource() }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                onClick = { tapCount++ }
                            ),
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            HomeContent(
                tapCount = tapCount,
                goToTutorial = goToTutorial,
                goToAdventure = goToAdventure,
                goToDebug = goToDebug
            )
            TextButton(
                onClick = goToCredit,
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(stringResource(R.string.credit))
            }
        }
    }
}

@Composable
private fun HomeContent(
    tapCount: Int,
    goToTutorial: () -> Unit,
    goToAdventure: () -> Unit,
    goToDebug: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(screenPadding),
        verticalArrangement = Arrangement.spacedBy(
            buttonPadding,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.home_text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )
        Button(onClick = goToTutorial) {
            Text(
                text = stringResource(R.string.tutorial),
                style = MaterialTheme.typography.headlineLarge
            )
        }
        Button(onClick = goToAdventure) {
            Text(
                text = stringResource(R.string.adventure),
                style = MaterialTheme.typography.headlineSmall
            )
        }
        AnimatedVisibility(
            visible = tapCount >= 10,
            enter = fadeIn()
        ) {
            Button(onClick = goToDebug) {
                Text(
                    text = stringResource(R.string.debug),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@ScreenPreview
@Composable
private fun HomeScreenPreview() {
    ZEscapeThemePreview {
        HomeScreen(
            goToTutorial = {},
            goToAdventure = {},
            goToDebug = {},
            goToCredit = {}
        )
    }
}

@ScreenPreview
@Composable
private fun DebugHomeContentPreview() {
    ZEscapeThemePreview {
        HomeContent(
            goToTutorial = {},
            goToAdventure = {},
            goToDebug = {},
            tapCount = 15
        )
    }
}
