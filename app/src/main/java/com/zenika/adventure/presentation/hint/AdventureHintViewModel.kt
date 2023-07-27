package com.zenika.adventure.presentation.hint

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
class AdventureHintViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _hintName: String =
        savedStateHandle.get<String>("hint") ?: error("Penalty is required")

    private var _hint = MutableStateFlow(_hintName)
    val hint: StateFlow<String?> = _hint
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = null
        )
}
