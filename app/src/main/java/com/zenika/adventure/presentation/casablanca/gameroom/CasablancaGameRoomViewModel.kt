package com.zenika.adventure.presentation.casablanca.gameroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import com.zenika.adventure.domain.RemoveNewItemBadgeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CasablancaGameRoomViewModel @Inject constructor(
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase,
    private val removeNewItemBadgeUseCase: RemoveNewItemBadgeUseCase
) : ViewModel() {
    val state: StateFlow<CasablancaGameRoomUiState> = combine(
        observeAdventureState(),
        observeRemainingTime()
    ) { gameState, remainingTime ->
        CasablancaGameRoomUiState(
            newItem = gameState.newItem,
            remainingTime = remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = CasablancaGameRoomUiState(newItem = false, remainingTime = 0)
        )

    fun removeNewItemBadge() {
        removeNewItemBadgeUseCase()
    }
}

class CasablancaGameRoomUiState(
    val newItem: Boolean,
    val remainingTime: Int
)
