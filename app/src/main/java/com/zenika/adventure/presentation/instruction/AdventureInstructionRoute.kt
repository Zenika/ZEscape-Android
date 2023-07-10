package com.zenika.adventure.presentation.instruction

import androidx.compose.runtime.Composable

@Composable
fun AdventureInstructionRoute(
    onDismissRequest: () -> Unit
) {
    AdventureInstructionDialog(
        onDismissRequest
    )
}