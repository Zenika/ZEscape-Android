package com.zenika.story.adventure.presentation.hint

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AdventureHintRoute(
    onDismissRequest: () -> Unit,
    viewModel: AdventureHintViewModel = hiltViewModel()
) {
    val hint by viewModel.hint.collectAsStateWithLifecycle()

    when (val hintName = hint) {
        null -> Unit
        else -> AdventureHintDialog(hintName, onDismissRequest)
    }
}
