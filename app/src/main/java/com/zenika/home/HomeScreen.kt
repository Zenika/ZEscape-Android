package com.zenika.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.zenika.R
import com.zenika.ui.theme.ZEscapeTheme
import com.zenika.ui.theme.buttonPadding
import com.zenika.ui.theme.screenPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    goToTutorial: () -> Unit,
    goToAdventure: () -> Unit,
    initInventoryTutorial: () -> Unit,
    initInventoryAdventure: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
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
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(
                buttonPadding,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.home_text),
                modifier = Modifier.padding(screenPadding),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium
            )
            Button(onClick = {
                goToTutorial()
                initInventoryTutorial()
            }) {
                Text(
                    text = stringResource(R.string.tutorial),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Button(onClick = {
                goToAdventure()
                initInventoryAdventure()
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
fun HomeScreenPreview() {
    ZEscapeTheme {
        HomeScreen(
            goToTutorial = {},
            goToAdventure = {},
            initInventoryTutorial = {},
            initInventoryAdventure = {}
        )
    }
}
