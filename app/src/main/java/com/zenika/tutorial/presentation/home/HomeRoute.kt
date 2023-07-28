package com.zenika.tutorial.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeRoute(
    backToHome: () -> Unit,
    goToScan: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        backToHome,
        goToScan,
        viewModel::finishGame
    )
}
