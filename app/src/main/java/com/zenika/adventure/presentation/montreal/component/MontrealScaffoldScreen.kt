package com.zenika.adventure.presentation.montreal.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.zenika.presentation.component.ReturnButton
import com.zenika.presentation.component.SettingsButton
import com.zenika.presentation.component.Timer
import com.zenika.ui.theme.screenPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MontrealScaffoldScreen(
    modifier: Modifier = Modifier,
    remainingTime: Int,
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    @DrawableRes
    background: Int,
    content: @Composable BoxScope.() -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Timer(remainingTime, Modifier.fillMaxWidth())
                },
                navigationIcon = {
                    ReturnButton(goBack = goBack)
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
                    painterResource(background),
                    contentScale = ContentScale.Crop
                )
                .padding(screenPadding),
            contentAlignment = Alignment.Center
        ) {
            CompositionLocalProvider(LocalContentColor provides Color.Black) {
                content()
            }
        }
    }
}