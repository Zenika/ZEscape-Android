package com.zenika.adventure.presentation.montreal.rooftop

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
class RooftopViewModel @Inject constructor(
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase
) : ViewModel() {
    val state: StateFlow<MontrealRooftopUiState> = combine(
        observeAdventureState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        MontrealRooftopUiState(
            newItem = gameState.newItem,
            remainingTime = remainingTime
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = MontrealRooftopUiState(newItem = false, remainingTime = 0)
    )
}

class MontrealRooftopUiState(
    val newItem: Boolean,
    val remainingTime: Int
)
