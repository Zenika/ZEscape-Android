package com.zenika.adventure.presentation.computer

import androidx.compose.runtime.Composable
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun ComputerRoute(
    backToPreviousScreen: () -> Unit,
    goToScan: () -> Unit
) {
    ComputerScreen(
        backToPreviousScreen,
        goToScan
    )
}

@ScreenPreview
@Composable
fun ComputerRoutePreview() {
    ZEscapeThemePreview {
        ComputerRoute(
            backToPreviousScreen = {},
            goToScan = {}
        )
    }
}
