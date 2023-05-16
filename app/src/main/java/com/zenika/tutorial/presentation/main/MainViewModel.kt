package com.zenika.tutorial.presentation.main

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
class MainViewModel @Inject constructor() : ViewModel() {

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
}
