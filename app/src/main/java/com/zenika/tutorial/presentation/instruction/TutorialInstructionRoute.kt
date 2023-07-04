package com.zenika.tutorial.presentation.instruction

import androidx.compose.runtime.Composable

@Composable
fun TutorialInstructionRoute(
    onDismissRequest: () -> Unit
) {
    TutorialInstructionDialog(
        onDismissRequest
    )
}