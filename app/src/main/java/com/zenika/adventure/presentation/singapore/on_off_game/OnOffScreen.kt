package com.zenika.adventure.presentation.singapore.on_off_game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zenika.adventure.presentation.component.Timer
import com.zenika.ui.theme.FalseButton
import com.zenika.ui.theme.TrueButton
import com.zenika.utils.ZEscapeThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnOffScreen(
    goToSettings: () -> Unit,
    remainingTime: Int,
    buttonsList: List<Boolean>,
    switchColor: (Int) -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Timer(
                    remainingTime,
                    Modifier.fillMaxWidth()
                )
            },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Search, "clueIcon")
                }
            },
            actions = {
                IconButton(onClick = goToSettings) {
                    Icon(Icons.Filled.Settings, "settingsIcon")
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(space = 12.dp, Alignment.CenterVertically),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(buttonsList.size) { buttonId ->
                Button(
                    buttonsList,
                    buttonId,
                    switchColor
                )
            }
        }
    }
}

@Composable
fun Button(
    buttonsList: List<Boolean>,
    buttonId: Int,
    switchColor: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (buttonsList[buttonId]) {
                    TrueButton
                } else {
                    FalseButton
                }
            )
            .size(100.dp)
            .clickable { switchColor(buttonId) }
    )
}

@Preview
@Composable
fun OnOffScreenPreview() {
    ZEscapeThemePreview {
        OnOffScreen(
            goToSettings = {},
            remainingTime = 3600,
            buttonsList = listOf(true, false, true, false, false, false),
            switchColor = {}
        )
    }
}