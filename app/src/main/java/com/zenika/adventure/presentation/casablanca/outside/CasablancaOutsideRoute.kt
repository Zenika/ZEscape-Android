package com.zenika.adventure.presentation.casablanca.outside

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CasablancaOutsideRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    enterInAgency: () -> Unit,
    viewModel: CasablancaOutsideViewModel = hiltViewModel(),
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    CasablancaOutsideScreen(
        remainingTime,
        goToSettings,
        openWorldMap,
        openInventory,
        enterInAgency
    )
}

