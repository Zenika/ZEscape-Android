package com.zenika.adventure.presentation.montreal.library

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.data.AdventureHint

@Composable
fun LibraryRoute(
    goToSettings: () -> Unit,
    goToRooftop: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    viewModel: LibraryViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                LibraryEvent.OPEN_INVENTORY -> openInventory()
            }
        }
    }

    LibraryScreen(
        remainingTime = state.remainingTime,
        newItem = state.newItem,
        goToSettings = goToSettings,
        goToRooftop = goToRooftop,
        openWorldMap = openWorldMap,
        openInventory = viewModel::openInventory,
        openHintValidation = openHintValidation
    )
}
