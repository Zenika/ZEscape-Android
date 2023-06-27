package com.zenika.adventure.presentation.instruction

import androidx.compose.runtime.Composable

@Composable
fun InstructionRoute(
    onDismissRequest: () -> Unit
) {
    InstructionDialog(
        onDismissRequest
    )
}