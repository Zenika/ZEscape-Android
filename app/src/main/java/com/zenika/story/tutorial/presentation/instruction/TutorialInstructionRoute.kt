package com.zenika.story.tutorial.presentation.instruction

import androidx.compose.runtime.Composable

@Composable
fun TutorialInstructionRoute(
    onDismissRequest: () -> Unit
) {
    TutorialInstructionDialog(
        onDismissRequest
    )
}
