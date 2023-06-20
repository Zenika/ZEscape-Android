package com.zenika.qrcode_scan

import androidx.compose.runtime.Composable
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun QrCodeScanRoute(
    backToPreviousScreen: () -> Unit,
    goToNextScreen: () -> Unit
) {
    QrCodeScanScreen(
        backToPreviousScreen,
        goToNextScreen
    )
}

@ScreenPreview
@Composable
fun QrCodeScanRoutePreview() {
    ZEscapeThemePreview {
        QrCodeScanRoute(
            backToPreviousScreen = {},
            goToNextScreen = {}
        )
    }
}