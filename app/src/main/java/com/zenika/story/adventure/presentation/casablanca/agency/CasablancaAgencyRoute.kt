package com.zenika.story.adventure.presentation.casablanca.agency

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.story.adventure.domain.model.AdventureHint

@Composable
fun CasablancaAgencyRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    openAgencyMap: () -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    goToSafe: () -> Unit,
    viewModel: CasablancaAgencyViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    CasablancaAgencyScreen(
        remainingTime = state.remainingTime,
        newItem = state.newItem,
        isSafeOpened = state.isSafeOpened,
        isKeyCollected = state.isKeyCollected,
        goToSettings = goToSettings,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        openAgencyMap = openAgencyMap,
        openHintValidation = openHintValidation,
        goToSafe = goToSafe,
        collectKey = viewModel::collectKey
    )
}

