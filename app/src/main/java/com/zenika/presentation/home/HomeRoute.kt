package com.zenika.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeRoute(
    goToTutorial: () -> Unit,
    goToAdventure: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                HomeEvent.TUTORIAL -> goToTutorial()
                HomeEvent.ADVENTURE -> goToAdventure()
            }
        }
    }

    HomeScreen(
        viewModel::goToTutorial,
        viewModel::goToAdventure
    )
}
