package com.zenika.story.adventure.presentation.home

import android.annotation.SuppressLint
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
import com.zenika.R
import com.zenika.common.component.ReturnButton
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.adventureBodyMedium
import com.zenika.theme.buttonPadding
import com.zenika.theme.screenPadding

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdventureHomeScreen(
    goBack: () -> Unit,
    goToAdventure: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.adventure),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    ReturnButton(goBack)
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
                .padding(screenPadding),
            verticalArrangement = Arrangement.spacedBy(
                buttonPadding,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.adventure_home_text),
                textAlign = TextAlign.Center,
                style = adventureBodyMedium
            )
            Button(onClick = goToAdventure) {
                Text(
                    text = stringResource(R.string.computerOn),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@ScreenPreview
@Composable
private fun AdventureHomeScreenPreview() {
    ZEscapeThemePreview {
        AdventureHomeScreen(
            goBack = {},
            goToAdventure = {}
        )
    }
}
