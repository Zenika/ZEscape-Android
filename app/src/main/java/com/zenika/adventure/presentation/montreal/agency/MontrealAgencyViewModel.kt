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
    observeRemainingTime: ObserveRemainingTimeUseCase,
    observeAdventureStateUseCase: ObserveAdventureStateUseCase
) : ViewModel() {
    val state: StateFlow<MontrealAgencyUiState> = combine(
        observeRemainingTime(), observeAdventureStateUseCase()
    ) { remainingTime, gameState ->
        MontrealAgencyUiState(
            remainingTime = remainingTime,
            isRooftopDiscovered = gameState.isRooftopDiscovered,
            isMeetingRoomDiscovered = gameState.isMeetingRoomDiscovered
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = MontrealAgencyUiState(
            remainingTime = 0,
            isRooftopDiscovered = false,
            isMeetingRoomDiscovered = false
        )
    )
}

class MontrealAgencyUiState(
    val remainingTime: Int,
    val isRooftopDiscovered: Boolean,
    val isMeetingRoomDiscovered: Boolean
)
