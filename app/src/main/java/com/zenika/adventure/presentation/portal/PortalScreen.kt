package com.zenika.adventure.presentation.portal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortalScreen(
    remainingTime: Int,
    goToSettings: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Timer(remainingTime, Modifier.fillMaxSize())
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
                    painterResource(id = R.mipmap.portal),
                    contentScale = ContentScale.FillHeight
                ),
            contentAlignment = Alignment.Center
        ) {
        }
    }
}

@ScreenPreview
@Composable
private fun PortalScreenPreview() {
    ZEscapeThemePreview {
        PortalScreen(
            remainingTime = 60,
            goToSettings = {}
        )
    }
}