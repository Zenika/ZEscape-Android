package com.zenika.adventure.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeRoute(
    backToHome: () -> Unit,
    goToAdventure: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        backToHome,
        goToAdventure,
        viewModel::finishGame
    )
}
