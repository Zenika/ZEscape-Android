package com.zenika.story.tutorial.presentation.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SettingsRoute(
    goBack: () -> Unit,
    goBackToHome: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val event by viewModel.events.collectAsStateWithLifecycle(initialValue = null)
    LaunchedEffect(event) {
        when (event) {
            SettingsEvent.HOME -> goBackToHome()
            null -> Unit
        }
    }

    SettingsScreen(
        goBack,
        viewModel::goBackToHome
    )
}
