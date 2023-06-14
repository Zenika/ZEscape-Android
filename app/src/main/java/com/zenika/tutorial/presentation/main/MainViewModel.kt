package com.zenika.tutorial.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.data.repository.ItemRepository
import com.zenika.tutorial.domain.GameUIState
import com.zenika.tutorial.domain.ObserveGameStateUseCase
import com.zenika.tutorial.domain.StartGameUseCase
import com.zenika.tutorial.domain.UpdateGameStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    private val startGameUseCase: StartGameUseCase,
    private val updateGameStateUseCase: UpdateGameStateUseCase,
    observeGameStateUseCase: ObserveGameStateUseCase,
) : ViewModel() {
    val state: StateFlow<GameUIState> = observeGameStateUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = GameUIState(
                chestOpened = false,
                mapCollected = false,
                keyCollected = false,
                newItem = false,
                remainingTime = 0
            )
        )

    init {
        viewModelScope.launch {
            startGameUseCase()
        }
    }

    fun collectKey() {
        viewModelScope.launch {
            itemRepository.addItem("key", R.mipmap.key)
            updateGameStateUseCase.collectKey()
        }
    }

    fun collectMap() {
        viewModelScope.launch {
            itemRepository.addItem("map", R.mipmap.rolled_map)
            updateGameStateUseCase.collectMap()
        }
    }

    fun removeNewItemBadge() {
        updateGameStateUseCase.removeNewItemBadge()
    }

    fun incrementClueCount() {
        updateGameStateUseCase.incrementClueCount()
    }
}


