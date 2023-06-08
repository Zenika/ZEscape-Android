package com.zenika.tutorial.presentation.score

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ScoreRoute(
    goToHome: () -> Unit,
    viewModel: ScoreViewModel = hiltViewModel()
) {
    val penalty by viewModel.penalty.collectAsState()
    val clue by viewModel.clue.collectAsState()
    val finalTimer by viewModel.finalTimer.collectAsState()

    Score(
        goToHome,
        penalty,
        clue,
        finalTimer
    )
}