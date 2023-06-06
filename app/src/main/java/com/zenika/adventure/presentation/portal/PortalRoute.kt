package com.zenika.adventure.presentation.portal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PortalRoute(
    viewModel: PortalViewModel = hiltViewModel(),
    goToSettings: () -> Unit
) {
    val remainingTime by viewModel.remainingTime.collectAsState()

    PortalScreen(
        remainingTime,
        goToSettings
    )
}

