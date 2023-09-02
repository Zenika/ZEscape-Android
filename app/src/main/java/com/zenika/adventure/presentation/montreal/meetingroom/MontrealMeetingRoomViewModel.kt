package com.zenika.adventure.presentation.montreal.meetingroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MontrealMeetingRoomViewModel @Inject constructor(
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase
) : ViewModel() {

    private val _events = MutableSharedFlow<MeetingRoomEvent>()
    val events = _events.asSharedFlow()

    val state: StateFlow<MontrealMeetingRoomUiState> = combine(
        observeAdventureState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        MontrealMeetingRoomUiState(
            newItem = gameState.newItem,
            isDoorOpen = gameState.isMontrealDoorOpen,
            remainingTime = remainingTime
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = MontrealMeetingRoomUiState(
            newItem = false,
            isDoorOpen = false,
            remainingTime = 0
        )
    )

    fun onButtonClick() {
        viewModelScope.launch {
            if (state.value.isDoorOpen) {
                _events.emit(MeetingRoomEvent.GO_TO_OFFICE)
            } else {
                _events.emit(MeetingRoomEvent.OPEN_CODE)
            }
        }
    }
}

class MontrealMeetingRoomUiState(
    val newItem: Boolean,
    val isDoorOpen: Boolean,
    val remainingTime: Int
)

enum class MeetingRoomEvent {
    OPEN_CODE,
    GO_TO_OFFICE
}
