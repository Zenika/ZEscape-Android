package com.zenika.story.adventure.presentation.montreal.instruction

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InstructionMontrealRoute(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    InstructionMontrealDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier
    )
}
