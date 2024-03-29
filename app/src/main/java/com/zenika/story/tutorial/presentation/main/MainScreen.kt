package com.zenika.story.tutorial.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.zenika.R
import com.zenika.common.component.SettingsButton
import com.zenika.common.component.Timer
import com.zenika.story.tutorial.presentation.main.component.Key
import com.zenika.story.tutorial.presentation.main.component.TreasureChest
import com.zenika.story.tutorial.presentation.main.component.TutorialInventoryBag
import com.zenika.theme.ScreenPreview
import com.zenika.theme.ZEscapeThemePreview
import com.zenika.theme.screenPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier,
    mainUiState: MainUiState,
    goToSettings: () -> Unit,
    openMiniGame: () -> Unit,
    openInventory: () -> Unit,
    showHint: () -> Unit,
    collectKey: () -> Unit,
    collectMap: () -> Unit
) {
    Scaffold(modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Timer(
                        mainUiState.remainingTime,
                        Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    HintIcon(onClick = showHint)
                },
                actions = {
                    SettingsButton(goToSettings)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .paint(
                    painterResource(R.mipmap.background_tutorial),
                    contentScale = ContentScale.Crop
                ),
            contentAlignment = Alignment.Center
        ) {
            TreasureChest(
                mainUiState.isChestOpened,
                mainUiState.isMapCollected,
                openMiniGame,
                collectMap
            )
            TutorialInventoryBag(
                Modifier
                    .align(Alignment.BottomEnd),
                mainUiState.newItem,
                openInventory
            )
            if (!mainUiState.isKeyCollected) {
                Key(
                    collectKey,
                    Modifier
                        .padding(screenPadding)
                        .align(Alignment.BottomStart),
                )
            }
        }
    }
}

@Composable
private fun HintIcon(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(Icons.Filled.Search, stringResource(R.string.hint))
    }
}

@ScreenPreview
@Composable
private fun TutorialScreenPreview() {
    ZEscapeThemePreview {
        MainScreen(
            Modifier
                .fillMaxSize(),
            mainUiState = MainUiState(
                isChestOpened = false,
                isMapCollected = false,
                isKeyCollected = false,
                newItem = false,
                remainingTime = 0
            ),
            goToSettings = {},
            openMiniGame = {},
            openInventory = {},
            showHint = {},
            collectKey = {},
            collectMap = {}
        )
    }
}
