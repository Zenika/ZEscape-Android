package com.zenika.presentation.qrcode_scan

import androidx.compose.runtime.Composable

@Composable
fun QrCodeScanRoute(
    goBack: () -> Unit,
    goToNextScreen: () -> Unit
) {
    QrCodeScanScreen(
        goBack,
        goToNextScreen
    )
}
