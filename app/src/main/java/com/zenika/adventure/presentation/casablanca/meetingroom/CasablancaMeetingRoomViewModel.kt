package com.zenika.adventure.presentation.casablanca.meetingroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.CollectCasablancaPaperUseCase
import com.zenika.adventure.domain.GetCasablancaPaperStateUseCase
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
class CasablancaMeetingRoomViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase,
    observeGameState: ObserveAdventureStateUseCase,
    getCasablancaPaperState: GetCasablancaPaperStateUseCase,
    private val collectCasablancaPaper: CollectCasablancaPaperUseCase
) : ViewModel() {
    val state: StateFlow<MeetingRoomUiState> = combine(
        getCasablancaPaperState(),
        observeGameState(),
        observeRemainingTime()
    ) { casablancaPaperCollected, gameState, remainingTime ->
        MeetingRoomUiState(
            casablancaPaperCollected,
            remainingTime,
            gameState.newItem
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = MeetingRoomUiState(
                isCasablancaPaperCollected = false,
                remainingTime = 0,
                newItem = false
            )
        )

    fun collectPaper() {
        viewModelScope.launch {
            collectCasablancaPaper()
        }
    }
}

class MeetingRoomUiState(
    val isCasablancaPaperCollected: Boolean,
    val remainingTime: Int,
    val newItem: Boolean
)
