package com.zenika.adventure.presentation.portal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.zenika.R
import com.zenika.adventure.presentation.component.ContinentsMap
import com.zenika.adventure.presentation.component.InventoryBag
import com.zenika.adventure.presentation.component.Timer
import com.zenika.presentation.component.SettingsButton
import com.zenika.presentation.component.Timer
import com.zenika.ui.theme.screenPadding
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortalScreen(
    remainingTime: Int,
    goToSettings: () -> Unit,
    accessToPortal: () -> Unit,
    openWorldMap: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Timer(remainingTime, Modifier.fillMaxWidth())
            },
            navigationIcon = {
                IconButton(onClick = {}) {
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
                    painterResource(id = R.mipmap.background_neon),
                    contentScale = ContentScale.FillHeight
                )
                .clickable(onClick = accessToPortal),
            contentAlignment = Alignment.Center
        ) {
            ContinentsMap(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomStart)
                    .clickable { openWorldMap() }
                    .padding(screenPadding)
            )
            InventoryBag(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomEnd)
                    .clickable { }
                    .padding(screenPadding)
            )
        }
    }
}

@ScreenPreview
@Composable
private fun PortalScreenPreview() {
    ZEscapeThemePreview {
        PortalScreen(
            remainingTime = 60,
            goToSettings = {},
            accessToPortal = {},
            openWorldMap = {}
        )
    }
}