package com.zenika.tutorial.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.tutorial.domain.CollectKeyUseCase
import com.zenika.tutorial.domain.CollectMapUseCase
import com.zenika.tutorial.domain.ObserveRemainingTimeUseCase
import com.zenika.tutorial.domain.ObserveTutorialStateUseCase
import com.zenika.tutorial.domain.UpdateGameStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val updateGameState: UpdateGameStateUseCase,
    private val collectKeyUseCase: CollectKeyUseCase,
    private val collectMapUseCase: CollectMapUseCase,
    observeTutorialState: ObserveTutorialStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase
) : ViewModel() {
    val state: StateFlow<MainUiState> = combine(
        observeTutorialState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        MainUiState(
            gameState.isChestOpened,
            gameState.isMapCollected,
            gameState.isKeyCollected,
            gameState.newItem,
            remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = MainUiState(
                isChestOpened = false,
                isMapCollected = false,
                isKeyCollected = false,
                newItem = false,
                remainingTime = 0
            )
        )

    fun collectKey() {
        viewModelScope.launch {
            collectKeyUseCase()
        }
    }

    fun collectMap() {
        viewModelScope.launch {
            collectMapUseCase()
        }
    }

    fun removeNewItemBadge() {
        updateGameState.removeNewItemBadge()
    }

    fun incrementHintCount() {
        updateGameState.incrementHintCount()
    }
}

class MainUiState(
    val isChestOpened: Boolean,
    val isMapCollected: Boolean,
    val isKeyCollected: Boolean,
    val newItem: Boolean,
    val remainingTime: Int
)

