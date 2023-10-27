package com.zenika.story.adventure.presentation.singapore.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.story.adventure.domain.model.AdventureHint

@Composable
fun SingaporeAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    viewModel: SingaporeAgencyViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SingaporeAgencyScreen(
        state,
        goToSettings,
        openWorldMap,
        openInventory,
        openHintValidation,
        viewModel::collectKey,
        viewModel::collectSword,
        viewModel::collectHook
    )
}
