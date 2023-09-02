package com.zenika.adventure.presentation.montreal.agencymap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MontrealAgencyMapViewModel @Inject constructor(
    observeAdventureStateUseCase: ObserveAdventureStateUseCase
) : ViewModel() {
    val state: StateFlow<MontrealAgencyUiState> = observeAdventureStateUseCase().map {
        MontrealAgencyUiState(
            it.isRooftopDiscovered,
            it.isMeetingRoomDiscovered
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = MontrealAgencyUiState(
                isRooftopDiscovered = false,
                isMeetingRoomDiscovered = false
            )
        )
}

class MontrealAgencyUiState(
    val isRooftopDiscovered: Boolean,
    val isMeetingRoomDiscovered: Boolean
)
