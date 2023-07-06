package com.zenika.adventure.presentation.penalty

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AdventurePenaltyRoute(
    onDismissRequest: () -> Unit,
    goBackToSingaporeAgency: () -> Unit,
    viewModel: AdventurePenaltyViewModel = hiltViewModel()
) {
    val penalty by viewModel.penalty.collectAsStateWithLifecycle()

    AdventurePenaltyDialog(
        onDismissRequest,
        goBackToSingaporeAgency,
        penalty
    )
}
