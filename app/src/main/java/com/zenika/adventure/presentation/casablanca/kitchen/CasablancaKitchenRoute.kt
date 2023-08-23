package com.zenika.adventure.presentation.casablanca.kitchen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun CasablancaKitchenRoute(
    goBack: () -> Unit,
    goToSettings: () -> Unit,
    openWorldMap: () -> Unit,
    openInventory: () -> Unit,
    viewModel: CasablancaKitchenViewModel = hiltViewModel()
) {
    val remainingTime by viewModel.remainingTime.collectAsStateWithLifecycle()

    CasablancaKitchenScreen(
        remainingTime,
        goBack,
        goToSettings,
        openWorldMap,
        openInventory
    )
}
