package com.zenika.tutorial.presentation.hint

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HintRoute(
    onDismissRequest: () -> Unit,
    viewModel: HintViewModel = hiltViewModel()
) {
    val hint = viewModel.currentHint

    HintDialog(
        hint,
        onDismissRequest
    )
}
