package com.zenika.tutorial.presentation.color_buttons_order_game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.data.state.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ColorButtonsOrderGameViewModel @Inject constructor(
    private val gameState: GameState
): ViewModel() {
    private val _events = MutableSharedFlow<MiniGameEvent>()
    val events = _events.asSharedFlow()

    private val _colorsSequence = MutableStateFlow(
        listOf<String>()
    )

    val sequenceSize: StateFlow<Int> = _colorsSequence.map { it.size }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = 0
        )

    private val colorsResult: List<String> = listOf("blue", "green", "red", "purple")

    fun addColor(color: String) {
        viewModelScope.launch {
            _colorsSequence.update { sequence ->
                sequence + color
            }
            if (!checkSequence()) {
                _events.emit(MiniGameEvent.DISMISS)
                initColorsSequence()
            } else if (sequenceSize.value >= 3) {
                _events.emit(MiniGameEvent.DISMISS)
                initColorsSequence()
                updateChestState()
            }
        }
    }

    private fun initColorsSequence() {
        viewModelScope.launch {
            _colorsSequence.update { listOf() }
        }
    }

    private fun checkSequence(): Boolean {
        return _colorsSequence.value[_colorsSequence.value.size - 1] ==
                colorsResult[_colorsSequence.value.size - 1]
    }

    private fun updateChestState() {
        gameState.openChest()
    }
}

enum class MiniGameEvent {
    DISMISS
}
