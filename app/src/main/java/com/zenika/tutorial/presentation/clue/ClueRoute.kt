package com.zenika.tutorial.presentation.clue

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.zenika.R

@Composable
fun ClueRoute(
    onDismissRequest: () -> Unit,
    viewModel: ClueViewModel = hiltViewModel()
) {
    val clue by viewModel.currentClue.collectAsState()

    if (clue != null) {
        ClueDialog(
            clue!!,
            onDismissRequest
        )
    } else {
        ClueDialog(
            R.string.noClue,
            onDismissRequest
        )
    }
}
