package com.zenika.adventure.presentation.montreal.agency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MontrealAgencyViewModel @Inject constructor(
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase
) : ViewModel() {
    val state: StateFlow<MontrealAgencyUiState> = combine(
        observeAdventureState(),
        observeRemainingTime(),
    ) { gameState, remainingTime ->
        MontrealAgencyUiState(
            newItem = gameState.newItem,
            remainingTime = remainingTime,
            isRooftopDiscovered = gameState.isRooftopDiscovered,
            isOfficeDiscovered = gameState.isOfficeDiscovered
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = MontrealAgencyUiState(
            newItem = false,
            remainingTime = 0,
            isRooftopDiscovered = false,
            isOfficeDiscovered = false
        )
    )
}

class MontrealAgencyUiState(
    val newItem: Boolean,
    val remainingTime: Int,
    val isRooftopDiscovered: Boolean,
    val isOfficeDiscovered: Boolean
)
