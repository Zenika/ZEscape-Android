package com.zenika.tutorial.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel() {

    private var _colorsSequence = MutableStateFlow(mutableListOf<String>())
    val colorsSequence: StateFlow<List<String>> = _colorsSequence
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = listOf("")
        )

    private var _sequenceSize = MutableStateFlow(0)
    val sequenceSize: StateFlow<Int> = _sequenceSize
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = 0
        )

    private var _chestState = MutableStateFlow(false)
    val chestState: StateFlow<Boolean> = _chestState
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = false
        )

    private var _collectedMap = MutableStateFlow(false)
    val collectedMap: StateFlow<Boolean> = _collectedMap
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = false
        )

    private val colorsResult: List<String> = listOf("blue", "green", "red", "yellow")

    fun initColorsSequence() {
        viewModelScope.launch {
            _colorsSequence.update { listOf<String>().toMutableList() }
            _sequenceSize.update { 0 }
        }
    }

    fun addColor(color: String) {
        viewModelScope.launch {
            _colorsSequence.update { sequence ->
                sequence.add(color)
                sequence
            }
            _sequenceSize.update { size ->
                size + 1 }
        }
    }

    fun updateChestState() {
        viewModelScope.launch {
            _chestState.update { state ->
                !state
            }
        }
    }

    fun updateMapState() {
        viewModelScope.launch {
            _collectedMap.update { state ->
                !state
            }
        }
    }

    fun checkSequence(): Boolean {
        return _colorsSequence.value[_colorsSequence.value.size - 1] ==
            colorsResult[_colorsSequence.value.size - 1]
    }
}
