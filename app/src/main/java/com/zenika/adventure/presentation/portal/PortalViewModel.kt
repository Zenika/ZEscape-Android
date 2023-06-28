package com.zenika.adventure.presentation.portal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.GetAdventureStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class PortalViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase,
    observeAdventureState: GetAdventureStateUseCase
) : ViewModel() {
    val state: StateFlow<PortalUiState> = combine(
        observeAdventureState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        PortalUiState(
            gameState.collectSingaporeKey,
            remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = PortalUiState(
                collectSingaporeKey = false,
                remainingTime = 3_600_600
            )
        )
}

class PortalUiState(
    val collectSingaporeKey: Boolean,
    val remainingTime: Int
)
