package com.zenika.adventure.presentation.computer

import androidx.compose.runtime.Composable

@Composable
fun ComputerRoute(
    goBack: () -> Unit,
    goToScan: () -> Unit
) {
    ComputerScreen(
        goBack,
        goToScan
    )
}
