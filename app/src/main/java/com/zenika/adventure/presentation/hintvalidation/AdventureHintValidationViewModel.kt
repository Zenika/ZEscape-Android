package com.zenika.adventure.presentation.hintvalidation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.IncrementHintCountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdventureHintValidationViewModel @Inject constructor(
    private val incrementHintCount: IncrementHintCountUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _hintName: String =
        savedStateHandle.get<String>("hint") ?: error("Hint is required")

    private var _hint = MutableStateFlow(_hintName)
    val hint: StateFlow<String> = _hint
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = _hintName
        )

    private val _events = MutableSharedFlow<AdventureHintEvent>()
    val events = _events.asSharedFlow()

    fun dismissHint() {
        viewModelScope.launch {
            _events.emit(AdventureHintEvent.DISMISS)
        }
    }

    fun showHint() {
        viewModelScope.launch {
            incrementHintCount()
            _events.emit(AdventureHintEvent.SHOW_HINT)
        }
    }
}

enum class AdventureHintEvent {
    DISMISS,
    SHOW_HINT
}
