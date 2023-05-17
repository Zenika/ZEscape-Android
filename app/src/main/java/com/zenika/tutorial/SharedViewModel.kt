package com.zenika.tutorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.data.state.GameState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    var gameState: MutableStateFlow<GameState> = MutableStateFlow(GameState())

    fun updateChestState() {
        viewModelScope.launch {
            gameState.update {
                GameState(chestState = true, mapState = false)
            }
        }
    }

    fun updateMapState() {
        viewModelScope.launch {
            gameState.update {
                GameState(chestState = true, mapState = true)
            }
        }
    }
}