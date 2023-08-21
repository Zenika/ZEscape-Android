package com.zenika.adventure.presentation.casablanca.kitchen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CasablancaKitchenRoute(
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: CasablancaKitchenViewModel = hiltViewModel()
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    CasablancaKitchenScreen(
        remainingTime,
        goToSettings,
        openWorldMap,
        openInventory
    )
}
