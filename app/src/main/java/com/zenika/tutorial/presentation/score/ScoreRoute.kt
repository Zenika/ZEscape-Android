package com.zenika.tutorial.presentation.score

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ScoreRoute(
    goToHome: () -> Unit,
    viewModel: ScoreViewModel = hiltViewModel()
) {
    val statistics = viewModel.statistics

    Score(
        goToHome,
        statistics
    )
}