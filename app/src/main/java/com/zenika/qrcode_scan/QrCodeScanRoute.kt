package com.zenika.qrcode_scan

import androidx.compose.runtime.Composable
import com.zenika.utils.ScreenPreview
import com.zenika.utils.ZEscapeThemePreview

@Composable
fun QrCodeScanRoute(
    backToHome: () -> Unit,
    goToNextScreen: () -> Unit
) {
    QrCodeScanScreen(
        backToHome,
        goToNextScreen
    )
}

@ScreenPreview
@Composable
fun QrCodeScanRoutePreview() {
    ZEscapeThemePreview {
        QrCodeScanRoute(
            backToHome = {},
            goToNextScreen = {}
        )
    }
}