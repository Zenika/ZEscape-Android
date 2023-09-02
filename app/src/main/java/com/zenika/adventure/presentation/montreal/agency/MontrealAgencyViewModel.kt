package com.zenika.adventure.presentation.montreal.agency

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
class MontrealAgencyViewModel @Inject constructor(
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase,
    private val removeNewItemBadgeUseCase: RemoveNewItemBadgeUseCase
) : ViewModel() {
    val state: StateFlow<MontrealAgencyUiState> = combine(
        observeAdventureState(),
        observeRemainingTime(),
    ) { gameState, remainingTime ->
        MontrealAgencyUiState(
            newItem = gameState.newItem,
            remainingTime = remainingTime,
            isRooftopDiscovered = gameState.isRooftopDiscovered,
            isMeetingRoomDiscovered = gameState.isMeetingRoomDiscovered
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = MontrealAgencyUiState(
            newItem = false,
            remainingTime = 0,
            isRooftopDiscovered = false,
            isMeetingRoomDiscovered = false
        )
    )

    fun removeNewItemBadge() {
        removeNewItemBadgeUseCase()
    }
}

class MontrealAgencyUiState(
    val newItem: Boolean,
    val remainingTime: Int,
    val isRooftopDiscovered: Boolean,
    val isMeetingRoomDiscovered: Boolean
)
