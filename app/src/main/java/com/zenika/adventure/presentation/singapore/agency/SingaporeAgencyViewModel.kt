package com.zenika.adventure.presentation.singapore.agency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.CollectHookUseCase
import com.zenika.adventure.domain.CollectSingaporeKeyUseCase
import com.zenika.adventure.domain.CollectSwordUseCase
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import com.zenika.adventure.domain.RemoveNewItemBadgeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingaporeAgencyViewModel @Inject constructor(
    getAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase,
    private val collectSingaporeKey: CollectSingaporeKeyUseCase,
    private val collectSwordItem: CollectSwordUseCase,
    private val collectHookItem: CollectHookUseCase,
    private val removeNewItemBadgeUseCase: RemoveNewItemBadgeUseCase
) : ViewModel() {

    val state: StateFlow<SingaporeUiState> = combine(
        getAdventureState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        SingaporeUiState(
            gameState.isSingaporeKeyCollected,
            gameState.isSwordCollected,
            gameState.isHookCollected,
            gameState.newItem,
            remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = SingaporeUiState(
                isSingaporeKeyCollected = false,
                isSwordCollected = false,
                isHookCollected = false,
                newItem = false,
                remainingTime = 0
            )
        )

    private val _event = MutableSharedFlow<SingaporeAgencyEvent>()
    val event = _event.asSharedFlow()

    fun collectKey() {
        viewModelScope.launch {
            collectSingaporeKey()
        }
    }

    fun collectSword() {
        viewModelScope.launch {
            collectSwordItem()
        }
    }

    fun collectHook() {
        viewModelScope.launch {
            collectHookItem()
        }
    }

    fun openInventory() {
        viewModelScope.launch {
            removeNewItemBadgeUseCase()
            _event.emit(SingaporeAgencyEvent.OPEN_INVENTORY)
        }
    }
}

class SingaporeUiState(
    val isSingaporeKeyCollected: Boolean,
    val isSwordCollected: Boolean,
    val isHookCollected: Boolean,
    val newItem: Boolean,
    val remainingTime: Int
)

enum class SingaporeAgencyEvent {
    OPEN_INVENTORY
}
