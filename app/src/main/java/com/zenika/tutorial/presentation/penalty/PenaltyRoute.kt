package com.zenika.tutorial.presentation.penalty

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PenaltyRoute(
    onDismissRequest: () -> Unit,
    viewModel: PenaltyViewModel = hiltViewModel()
) {
    val penalty by viewModel.penalty.collectAsState()

    PenaltyDialog(
        onDismissRequest,
        penalty
    )
}