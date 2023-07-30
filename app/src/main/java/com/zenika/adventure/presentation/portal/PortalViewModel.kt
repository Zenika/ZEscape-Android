package com.zenika.adventure.presentation.portal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.FinishGameUseCase
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
    getAdventureState: GetAdventureStateUseCase,
    private val finishGameUseCase: FinishGameUseCase
) : ViewModel() {
    val state: StateFlow<PortalUiState> = combine(
        getAdventureState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        PortalUiState(
            gameState.isSingaporeKeyCollected,
            remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = PortalUiState(
                isSingaporeKeyCollected = false,
                remainingTime = 0
            )
        )

    fun finishGame() {
        finishGameUseCase()
    }
}

class PortalUiState(
    val isSingaporeKeyCollected: Boolean,
    val remainingTime: Int
)
