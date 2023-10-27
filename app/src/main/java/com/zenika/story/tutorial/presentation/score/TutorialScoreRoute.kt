package com.zenika.story.tutorial.presentation.score

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TutorialScoreRoute(
    goBackToHome: () -> Unit,
    viewModel: TutorialScoreViewModel = hiltViewModel()
) {
    BackHandler {
        // Player cannot return to tutorial when the game is finished.
    }

    val statistics = viewModel.statistics

    TutorialScore(
        goBackToHome,
        statistics
    )
}
