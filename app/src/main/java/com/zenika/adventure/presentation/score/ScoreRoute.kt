package com.zenika.adventure.presentation.score

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ScoreRoute(
    goToHome: () -> Unit,
    viewModel: ScoreViewModel = hiltViewModel()
) {
    val statistics = viewModel.statistics

    ScoreScreen(
        goToHome,
        statistics
    )
}