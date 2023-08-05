package com.zenika.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeRoute(
    goToTutorial: () -> Unit,
    goToAdventure: () -> Unit,
    goToDebug: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val event by viewModel.events.collectAsStateWithLifecycle(initialValue = null)
    LaunchedEffect(event) {
        when (event) {
            HomeEvent.TUTORIAL -> goToTutorial()
            HomeEvent.ADVENTURE -> goToAdventure()
            HomeEvent.DEBUG -> goToDebug()
            null -> Unit
        }
    }

    HomeScreen(
        viewModel::goToTutorial,
        viewModel::goToAdventure,
        viewModel::goToDebug
    )
}
