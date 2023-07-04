package com.zenika.presentation.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingsRoute(
    goBack: () -> Unit,
    goBackToHome: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                SettingsEvent.HOME -> goBackToHome()
            }
        }
    }

    SettingsScreen(
        goBack,
        viewModel::goBackToHome
    )
}
