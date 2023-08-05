package com.zenika.tutorial.presentation.main

import android.annotation.SuppressLint
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
import com.zenika.presentation.component.SettingsButton
import com.zenika.presentation.component.Timer
import com.zenika.tutorial.presentation.main.component.Key
import com.zenika.tutorial.presentation.main.component.TreasureChest
import com.zenika.tutorial.presentation.main.component.TutorialInventoryBag
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
                    IconButton(onClick = {
                        showHint()
                        incrementHintCount()
                    }) {
                        Icon(Icons.Filled.Search, stringResource(R.string.hint))
                    }
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
                    painterResource(R.mipmap.background1),
                    contentScale = ContentScale.FillHeight
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
