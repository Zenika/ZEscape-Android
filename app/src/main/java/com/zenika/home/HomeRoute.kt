package com.zenika.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.ui.theme.ZEscapeTheme

@Composable
fun HomeRoute(
    goToTutorial: () -> Unit,
    goToAdventure: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        goToTutorial,
        goToAdventure,
        viewModel::initInventoryTutorial,
        viewModel::initInventoryAdventure
    )
}


@Preview
@Composable
fun HomeRoutePreview() {
    ZEscapeTheme {
        HomeRoute(
            goToTutorial = {},
            goToAdventure = {}
        )
    }
}