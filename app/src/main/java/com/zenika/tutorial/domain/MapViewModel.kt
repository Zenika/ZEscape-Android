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
class MapViewModel @Inject constructor() : ViewModel() {

    private var _welcomeMap1Visible = MutableStateFlow(true)
    val welcomeMap1Visible: StateFlow<Boolean> = _welcomeMap1Visible
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = true
        )

    private var _welcomeMap2Visible = MutableStateFlow(false)
    val welcomeMap2Visible: StateFlow<Boolean> = _welcomeMap2Visible
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = false
        )

    private var _endMapVisible = MutableStateFlow(true)
    val endMapVisible: StateFlow<Boolean> = _endMapVisible
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = true
        )

    fun hideWelcomeFirstMap() {
        viewModelScope.launch {
            _welcomeMap1Visible.update { state ->
                !state
            }
        }
        showSecondMap()
    }

    fun hideWelcomeSecondMap() {
        viewModelScope.launch {
            _welcomeMap2Visible.update { state ->
                !state
            }
        }
    }

    private fun showSecondMap() {
        viewModelScope.launch {
            _welcomeMap2Visible.update { state ->
                !state
            }
        }
    }

    fun hideEndMap() {
        viewModelScope.launch {
            _endMapVisible.update { state ->
                !state
            }
        }
    }
}