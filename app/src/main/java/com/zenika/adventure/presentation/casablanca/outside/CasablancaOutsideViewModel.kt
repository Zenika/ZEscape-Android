package com.zenika.adventure.presentation.casablanca.outside

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ApplyPenaltyUseCase
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import com.zenika.adventure.domain.OpenCasablancaAgencyUseCase
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
class CasablancaOutsideViewModel @Inject constructor(
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase,
    private val applyPenaltyUseCase: ApplyPenaltyUseCase,
    private val openCasablancaAgency: OpenCasablancaAgencyUseCase
) : ViewModel() {
    val state: StateFlow<CasablancaOutsideUiState> =
        combine(
            observeAdventureState(),
            observeRemainingTime(),
        ) { gameState, remainingTime ->
            CasablancaOutsideUiState(
                newItem = gameState.newItem,
                remainingTime = remainingTime
            )
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = CasablancaOutsideUiState(
                    newItem = false,
                    remainingTime = 0
                )
            )

    private val _events = MutableSharedFlow<CasablancaEvent>()
    val events = _events.asSharedFlow()

    fun enterInAgency() {
        viewModelScope.launch {
            openCasablancaAgency()
            _events.emit(CasablancaEvent.ENTRY)
        }
    }

    fun applyPenalty(penalty: String) {
        viewModelScope.launch {
            when (penalty) {
                "door" -> _events.emit(CasablancaEvent.PENALTY_DOOR)
                "hotel" -> _events.emit(CasablancaEvent.PENALTY_HOTEL)
                "intercom" -> _events.emit(CasablancaEvent.PENALTY_INTERCOM)
            }
            applyPenaltyUseCase()
        }
    }
}

class CasablancaOutsideUiState(
    val newItem: Boolean,
    val remainingTime: Int
)

enum class CasablancaEvent {
    ENTRY,
    PENALTY_DOOR,
    PENALTY_HOTEL,
    PENALTY_INTERCOM
}
