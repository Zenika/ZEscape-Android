package com.zenika.tutorial.presentation.instruction

import androidx.compose.runtime.Composable

@Composable
fun InstructionRoute(
    onDismissRequest: () -> Unit
) {
    InstructionDialog(
        onDismissRequest
    )
}