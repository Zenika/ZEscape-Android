package com.zenika.tutorial.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.data.repository.ItemRepository
import com.zenika.data.state.GameState
import com.zenika.data.timer.TimerServiceManager
import com.zenika.tutorial.domain.InitCluesUseCase
import com.zenika.tutorial.domain.InitInventoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val itemRepository: ItemRepository,
    private val initInventoryUseCase: InitInventoryUseCase,
    private val initCluesUseCase: InitCluesUseCase,
    private val gameState: GameState,
    timerServiceManager: TimerServiceManager
) : ViewModel() {
    val state =
        combine(
            gameState.chestOpened,
            gameState.mapCollected,
            gameState.keyCollected,
            gameState.newItem,
            timerServiceManager.remaining
        ) { chestOpened, mapCollected, keyCollected, newItem, remainingTimer ->
            GameUIState(chestOpened, mapCollected, keyCollected, newItem, remainingTimer)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = GameUIState(
                    chestOpened = false,
                    mapCollected = false,
                    keyCollected = false,
                    newItem = false,
                    remainingTimer = 3600000
                )
            )

    init {
        viewModelScope.launch {
            initInventoryUseCase()
            initCluesUseCase()
        }
        gameState.initGame()
        timerServiceManager.startTimer()
    }

    fun collectKey() {
        addItem("key", R.mipmap.key)
        gameState.collectKey()
    }

    fun collectMap() {
        addItem("map", R.mipmap.rolled_map)
        gameState.collectMap()
    }

    fun removeNewItemBadge() {
        gameState.removeNewItemBadge()
    }

    private fun addItem(itemName: String, itemRes: Int) {
        viewModelScope.launch {
            itemRepository.addItem(itemName, itemRes)
        }
    }

    fun incrementClueCount() {
        gameState.incrementClueCount()
    }
}

class GameUIState(
    val chestOpened: Boolean,
    val mapCollected: Boolean,
    val keyCollected: Boolean,
    val newItem: Boolean,
    val remainingTimer: Int
)
