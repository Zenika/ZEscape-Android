package com.zenika.adventure.presentation.montreal.meetingroom.code

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ApplyPenaltyUseCase
import com.zenika.adventure.domain.OpenMontrealDoorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val MAX_SIZE_CODE = 4

@HiltViewModel
class MontrealCodeViewModel @Inject constructor(
    private val openMontrealDoor: OpenMontrealDoorUseCase,
    private val applyPenaltyUseCase: ApplyPenaltyUseCase
) : ViewModel() {
    private val _events = MutableSharedFlow<MontrealCodeEvent>()
    val events = _events.asSharedFlow()

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
            if (code.length < MAX_SIZE_CODE) {
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
            if (code.value == "7439") {
                openMontrealDoor()
                _events.emit(MontrealCodeEvent.GO_TO_OFFICE)
            } else {
                applyPenalty()
            }
        }
    }

    fun applyPenalty() {
        viewModelScope.launch {
            _events.emit(MontrealCodeEvent.APPLY_PENALTY)
            applyPenaltyUseCase()
        }
    }
}

enum class MontrealCodeEvent {
    APPLY_PENALTY,
    GO_TO_OFFICE
}
