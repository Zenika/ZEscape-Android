package com.zenika.adventure.presentation.singapore.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.data.AdventureHint

@Composable
fun SingaporeAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    viewModel: SingaporeAgencyViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.event.collect {event->
            when(event) {
                SingaporeAgencyEvent.OPEN_INVENTORY -> openInventory()
            }
        }
    }

    SingaporeAgencyScreen(
        state,
        goToSettings,
        openWorldMap,
        viewModel::openInventory,
        openHintValidation,
        viewModel::collectKey,
        viewModel::collectSword,
        viewModel::collectHook
    )
}
