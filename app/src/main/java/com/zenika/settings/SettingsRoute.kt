package com.zenika.settings

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.ui.theme.ZEscapeTheme

@Composable
fun SettingsRoute(
    backToPreviousScreen: () -> Unit,
    backToHome: () -> Unit,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    SettingsScreen(
        backToPreviousScreen,
        backToHome,
        viewModel::finishGame
    )
}

@Preview
@Composable
fun SettingsRoutePreview() {
    ZEscapeTheme {
        SettingsRoute(
            backToPreviousScreen = {},
            backToHome = {}
        )
    }
}