package com.zenika.adventure.presentation.computer

import androidx.compose.runtime.Composable
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

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

@ScreenPreview
@Composable
fun ComputerRoutePreview() {
    ZEscapeThemePreview {
        ComputerRoute(
            goBack = {},
            goToScan = {}
        )
    }
}
