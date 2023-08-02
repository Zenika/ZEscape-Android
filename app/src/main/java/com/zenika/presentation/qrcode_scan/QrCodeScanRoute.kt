package com.zenika.presentation.qrcode_scan

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun QrCodeScanRoute(
    goBack: () -> Unit,
    goToNextScreen: () -> Unit,
    viewModel: QrCodeScanViewModel = hiltViewModel()
) {
    val qrcode by viewModel.qrcode.collectAsStateWithLifecycle()

    when (val qrcodeName = qrcode) {
        null -> Unit
        else -> QrCodeScanScreen(
            qrcodeName,
            goBack,
            goToNextScreen
        )
    }
}
