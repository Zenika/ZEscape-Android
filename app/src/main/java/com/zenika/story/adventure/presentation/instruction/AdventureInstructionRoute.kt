package com.zenika.story.adventure.presentation.instruction

import androidx.compose.runtime.Composable

@Composable
fun AdventureInstructionRoute(
    onDismissRequest: () -> Unit
) {
    AdventureInstructionDialog(
        onDismissRequest
    )
}
