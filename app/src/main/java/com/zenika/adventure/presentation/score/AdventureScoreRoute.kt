package com.zenika.adventure.presentation.score

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AdventureScoreRoute(
    goBackToHome: () -> Unit,
    viewModel: AdventureScoreViewModel = hiltViewModel()
) {
    BackHandler {
        // Player cannot return to adventure when the game is finished.
    }

    val statistics = viewModel.statistics

    AdventureScoreScreen(
        goBackToHome,
        statistics
    )
}
