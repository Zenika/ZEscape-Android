package com.zenika.story.adventure.presentation.casablanca.outside

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zenika.story.adventure.domain.model.AdventureHint

@Composable
fun CasablancaOutsideRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    enterInAgency: () -> Unit,
    openPenalty: (String) -> Unit,
    openHintValidation: (AdventureHint) -> Unit,
    viewModel: CasablancaOutsideViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                CasablancaEvent.ENTRY -> enterInAgency()
                CasablancaEvent.PENALTY_DOOR -> openPenalty("door")
                CasablancaEvent.PENALTY_HOTEL -> openPenalty("hotel")
                CasablancaEvent.PENALTY_INTERCOM -> openPenalty("intercom")
            }
        }
    }

    CasablancaOutsideScreen(
        remainingTime = state.remainingTime,
        newItem = state.newItem,
        goToSettings = goToSettings,
        openWorldMap = openWorldMap,
        openInventory = openInventory,
        openHintValidation = openHintValidation,
        enterInAgency = viewModel::enterInAgency,
        applyPenalty = viewModel::applyPenalty
    )
}
