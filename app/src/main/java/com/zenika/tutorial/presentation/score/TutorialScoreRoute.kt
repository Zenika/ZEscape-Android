package com.zenika.tutorial.presentation.score

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TutorialScoreRoute(
    goBackToHome: () -> Unit,
    viewModel: TutorialScoreViewModel = hiltViewModel()
) {
    val statistics = viewModel.statistics

    TutorialScore(
        goBackToHome,
        statistics
    )
}