package com.zenika.tutorial.presentation.hint

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HintRoute(
    onDismissRequest: () -> Unit,
    viewModel: HintViewModel = hiltViewModel()
) {
    val hint by viewModel.currentHint.collectAsState()

    HintDialog(
        hint,
        onDismissRequest
    )
}
