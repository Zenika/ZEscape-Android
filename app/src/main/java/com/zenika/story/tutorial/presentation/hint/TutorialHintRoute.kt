package com.zenika.story.tutorial.presentation.hint

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TutorialHintRoute(
    onDismissRequest: () -> Unit,
    viewModel: TutorialHintViewModel = hiltViewModel()
) {
    val hint = viewModel.currentHint

    TutorialHintDialog(
        hint,
        onDismissRequest
    )
}
