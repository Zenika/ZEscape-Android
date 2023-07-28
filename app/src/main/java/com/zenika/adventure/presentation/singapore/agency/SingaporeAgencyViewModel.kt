package com.zenika.adventure.presentation.singapore.agency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.CollectHookUseCase
import com.zenika.adventure.domain.CollectSingaporeKeyUseCase
import com.zenika.adventure.domain.CollectSwordUseCase
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingaporeAgencyViewModel @Inject constructor(
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase,
    private val collectSingaporeKey: CollectSingaporeKeyUseCase,
    private val collectSwordItem: CollectSwordUseCase,
    private val collectHookItem: CollectHookUseCase
) : ViewModel() {

    val state: StateFlow<SingaporeUiState> = combine(
        observeAdventureState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        SingaporeUiState(
            gameState.isSingaporeKeyCollected,
            gameState.isSwordCollected,
            gameState.isHookCollected,
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
                remainingTime = 0
            )
        )

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

}

class SingaporeUiState(
    val isSingaporeKeyCollected: Boolean,
    val isSwordCollected: Boolean,
    val isHookCollected: Boolean,
    val remainingTime: Int
)
