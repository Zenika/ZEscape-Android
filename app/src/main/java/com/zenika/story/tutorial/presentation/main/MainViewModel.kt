package com.zenika.story.tutorial.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.story.tutorial.domain.CollectKeyUseCase
import com.zenika.story.tutorial.domain.CollectMapUseCase
import com.zenika.story.tutorial.domain.ObserveRemainingTimeUseCase
import com.zenika.story.tutorial.domain.ObserveTutorialStateUseCase
import com.zenika.story.tutorial.domain.OpenInventoryUseCase
import com.zenika.story.tutorial.domain.ShowHintUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val collectKeyUseCase: CollectKeyUseCase,
    private val collectMapUseCase: CollectMapUseCase,
    private val onInventoryOpened: OpenInventoryUseCase,
    private val onHintShown: ShowHintUseCase,
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

    private val _event = MutableStateFlow(MainEvent.NONE)
    val event = _event.asStateFlow()

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

    fun openInventory() {
        viewModelScope.launch {
            onInventoryOpened()
            _event.emit(MainEvent.OPEN_INVENTORY)
        }
    }

    fun showHint() {
        viewModelScope.launch {
            onHintShown()
            _event.emit(MainEvent.SHOW_HINT)
        }
    }

    fun onEventHandled() {
        viewModelScope.launch {
            _event.emit(MainEvent.NONE)
        }
    }
}

class MainUiState(
    val isChestOpened: Boolean,
    val isMapCollected: Boolean,
    val isKeyCollected: Boolean,
    val newItem: Boolean,
    val remainingTime: Int
)

enum class MainEvent {
    OPEN_INVENTORY,
    SHOW_HINT,
    NONE
}

