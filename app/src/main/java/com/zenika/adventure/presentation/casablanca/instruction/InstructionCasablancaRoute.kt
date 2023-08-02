package com.zenika.adventure.presentation.casablanca.instruction

import androidx.compose.runtime.Composable

@Composable
fun InstructionCasablancaRoute(
    onDismissRequest: () -> Unit
) {
    InstructionCasablancaDialog(
        onDismissRequest
    )
}
