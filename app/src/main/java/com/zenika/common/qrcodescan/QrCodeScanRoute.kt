package com.zenika.common.qrcodescan

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun QrCodeScanRoute(
    goBack: () -> Unit,
    onCodeScanned: (String) -> Unit,
    viewModel: QrCodeScanViewModel = hiltViewModel()
) {
    val qrcode by viewModel.qrcode.collectAsStateWithLifecycle()

    when (val qrcodeName = qrcode) {
        null -> Unit
        else -> QrCodeScanScreen(
            qrcodeName,
            goBack,
            onCodeScanned
        )
    }
}
