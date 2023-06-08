package com.zenika.tutorial.presentation.clue

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ClueRoute(
    onDismissRequest: () -> Unit,
    viewModel: ClueViewModel = hiltViewModel()
) {
    val clue by viewModel.currentClue.collectAsState()

    clue?.let {
        ClueDialog(
            it,
        onDismissRequest
    )
    }
}
