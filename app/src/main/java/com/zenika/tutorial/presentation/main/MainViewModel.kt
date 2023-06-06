package com.zenika.tutorial.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.data.repository.ItemRepository
import com.zenika.tutorial.domain.ObserveRemainingTimeUseCase
import com.zenika.tutorial.domain.ObserveTutorialStateUseCase
import com.zenika.tutorial.domain.StartTutorialGameUseCase
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
    private val itemRepository: ItemRepository,
    private val startGame: StartTutorialGameUseCase,
    private val updateGameState: UpdateGameStateUseCase,
    observeTutorialState: ObserveTutorialStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase
) : ViewModel() {
    val state: StateFlow<MainUiState> = combine(
        observeTutorialState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        MainUiState(
            gameState.chestOpened,
            gameState.mapCollected,
            gameState.keyCollected,
            gameState.newItem,
            remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = MainUiState(
                chestOpened = false,
                mapCollected = false,
                keyCollected = false,
                newItem = false,
                remainingTime = 3_600_600
            )
        )

    init {
        viewModelScope.launch {
            startGame()
        }
    }

    fun collectKey() {
        viewModelScope.launch {
            itemRepository.addItem("key", R.mipmap.key)
            updateGameState.collectKey()
        }
    }

    fun collectMap() {
        viewModelScope.launch {
            itemRepository.addItem("map", R.mipmap.rolled_map)
            updateGameState.collectMap()
        }
    }

    fun removeNewItemBadge() {
        updateGameState.removeNewItemBadge()
    }

    fun incrementClueCount() {
        updateGameState.incrementHintCount()
    }
}

class MainUiState(
    val chestOpened: Boolean,
    val mapCollected: Boolean,
    val keyCollected: Boolean,
    val newItem: Boolean,
    val remainingTime: Int
)

