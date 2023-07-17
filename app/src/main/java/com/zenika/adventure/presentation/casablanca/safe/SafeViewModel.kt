package com.zenika.adventure.presentation.casablanca.safe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.OpenSafeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SafeViewModel @Inject constructor(
    private val openSafe: OpenSafeUseCase
) : ViewModel() {
    private var _code = MutableStateFlow("")
    val code: StateFlow<String> = _code
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = ""
        )

    fun addNumber(number: String) {
        _code.update { code ->
            var newCode = code
            if (code.length < 6) {
                Log.d("code", code)
                newCode = code + number
            }
            newCode
        }
    }

    fun clearNumber() {
        _code.update { code ->
            var newCode = code
            if (code.isNotEmpty()) {
                newCode = code.dropLast(1)
            }
            newCode
        }
    }

    fun checkCode() {
        viewModelScope.launch {
            if (code.value == "531296") {
                openSafe()
            }
        }
    }
}
