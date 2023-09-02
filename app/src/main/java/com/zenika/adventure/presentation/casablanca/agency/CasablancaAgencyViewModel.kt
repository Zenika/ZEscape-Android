package com.zenika.adventure.presentation.casablanca.agency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.CollectCasablancaKeyUseCase
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.adventure.domain.ObserveCasablancaKeyStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import com.zenika.adventure.domain.ObserveSafeStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CasablancaAgencyViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase,
    observeSafeStateUseCase: ObserveSafeStateUseCase,
    observeCasablancaKeyState: ObserveCasablancaKeyStateUseCase,
    observeAdventureState: ObserveAdventureStateUseCase,
    private val collectCasablancaKey: CollectCasablancaKeyUseCase
) : ViewModel() {

    val state: StateFlow<CasablancaUiState> = combine(
        observeRemainingTime(),
        observeSafeStateUseCase(),
        observeCasablancaKeyState(),
        observeAdventureState()
    ) { remainingTime, safeState, keyState, gameState ->
        CasablancaUiState(
            isSafeOpened = safeState,
            isKeyCollected = keyState,
            newItem = gameState.newItem,
            remainingTime = remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = CasablancaUiState(
                isSafeOpened = false,
                isKeyCollected = false,
                newItem = false,
                remainingTime = 0
            )
        )

    fun collectKey() {
        viewModelScope.launch {
            collectCasablancaKey()
        }
    }
}

data class CasablancaUiState(
    val isSafeOpened: Boolean,
    val isKeyCollected: Boolean,
    val newItem: Boolean,
    val remainingTime: Int
)
