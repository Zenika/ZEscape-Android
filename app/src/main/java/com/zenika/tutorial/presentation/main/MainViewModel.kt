package com.zenika.tutorial.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.R
import com.zenika.data.repository.ItemRepository
import com.zenika.data.state.GameState
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
    private val gameState: GameState
) : ViewModel() {
    val state =
        combine(gameState.chestOpened, gameState.mapCollected) { chestOpened, mapCollected ->
            GameUIState(chestOpened, mapCollected)
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = GameUIState(chestOpened = false, mapCollected = false)
            )

    init {
        Log.d("init inventory", "ok")
        viewModelScope.launch {
            initInventoryUseCase()
        }
    }

    fun collectMap() {
        addItem("map", R.mipmap.rolled_map)
        gameState.collectMap()
    }

    private fun addItem(itemName: String, itemRes: Int) {
        viewModelScope.launch {
            itemRepository.addItem(itemName, itemRes)
        }
    }
}

class GameUIState(
    val chestOpened: Boolean,
    val mapCollected: Boolean
)
