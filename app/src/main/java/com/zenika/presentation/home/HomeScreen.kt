package com.zenika.presentation.home

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.R
import com.zenika.ui.theme.buttonPadding
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ZEscapeThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    goToTutorial: () -> Unit,
    goToAdventure: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        Modifier
                            .fillMaxWidth(),
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
        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(screenPadding),
            verticalArrangement = Arrangement.spacedBy(
                buttonPadding,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.home_text),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
            Button(onClick = {
                goToTutorial()
            }) {
                Text(
                    text = stringResource(R.string.tutorial),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            Button(onClick = {
                goToAdventure()
            }) {
                Text(
                    text = stringResource(R.string.adventure),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}



@Preview
@Composable
private fun HomeScreenPreview() {
    ZEscapeThemePreview {
        HomeScreen(
            goToTutorial = {},
            goToAdventure = {}
        )
    }
}
