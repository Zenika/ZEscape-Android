package com.zenika.common.qrcodescan

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class QrCodeScanViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var qrcodeName: String =
        savedStateHandle.get<String>("qrcode") ?: error("QrCode is required")

    private var _qrcode = MutableStateFlow(qrcodeName)
    val qrcode: StateFlow<String?> = _qrcode
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = null
        )
}
