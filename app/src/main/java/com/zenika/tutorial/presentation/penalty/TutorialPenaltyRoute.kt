package com.zenika.tutorial.presentation.penalty

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun TutorialPenaltyRoute(
    onDismissRequest: () -> Unit,
    viewModel: TutorialPenaltyViewModel = hiltViewModel()
) {
    val penalty by viewModel.penalty.collectAsStateWithLifecycle()

    TutorialPenaltyDialog(
        onDismissRequest,
        penalty
    )
}