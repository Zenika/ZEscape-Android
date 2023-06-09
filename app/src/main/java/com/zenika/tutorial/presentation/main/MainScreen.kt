package com.zenika.tutorial.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
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
import com.zenika.tutorial.presentation.main.component.InventoryBag
import com.zenika.tutorial.presentation.main.component.Key
import com.zenika.tutorial.presentation.main.component.Timer
import com.zenika.tutorial.presentation.main.component.TreasureChest
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier,
    gameUIState: GameUIState,
    openMiniGame: () -> Unit,
    openInventory: () -> Unit,
    showClue: () -> Unit,
    collectKey: () -> Unit,
    collectMap: () -> Unit,
    removeNewItemBadge: () -> Unit,
    incrementClueCount: () -> Unit
) {
    Scaffold(modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Timer(
                        gameUIState.remainingTimer
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        showClue()
                        incrementClueCount()
                    }) {
                        Icon(Icons.Filled.Search, stringResource(R.string.clue_icon))
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Settings, stringResource(R.string.settings_icon))
                    }
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
                    painterResource(id = R.mipmap.background1),
                    contentScale = ContentScale.FillHeight
                ),
            contentAlignment = Alignment.Center
        ) {
            TreasureChest(
                gameUIState.chestOpened,
                gameUIState.mapCollected,
                openMiniGame,
                collectMap
            )
            InventoryBag(
                Modifier
                    .align(Alignment.BottomEnd),
                gameUIState.newItem,
                openInventory,
                removeNewItemBadge
            )
            if (!gameUIState.keyCollected) {
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
fun TutorialScreenPreview() {
    ZEscapeThemePreview {
        MainScreen(
            Modifier
                .fillMaxSize(),
            gameUIState = GameUIState(
                chestOpened = false,
                mapCollected = false,
                keyCollected = false,
                newItem = false,
                remainingTimer = 60
            ),
            openMiniGame = {},
            openInventory = {},
            showClue = {},
            collectKey = {},
            collectMap = {},
            removeNewItemBadge = {},
            incrementClueCount = {}
        )
    }
}
