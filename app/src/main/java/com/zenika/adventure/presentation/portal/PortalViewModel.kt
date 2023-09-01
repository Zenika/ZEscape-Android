package com.zenika.adventure.presentation.portal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.FinishGameUseCase
import com.zenika.adventure.domain.ObserveKeyCollectionUseCase
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
class PortalViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase,
    observeKeyCollection: ObserveKeyCollectionUseCase,
    private val finishGameUseCase: FinishGameUseCase
) : ViewModel() {
    val state: StateFlow<PortalUiState> = combine(
        observeKeyCollection(), observeRemainingTime()
    ) { keyCollection, remainingTime ->
        PortalUiState(
            portalCanBeOpened = keyCollection.isSingaporeKeyCollected && keyCollection.isCasablancaKeyCollected,
            remainingTime
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = PortalUiState(
                portalCanBeOpened = false,
                remainingTime = 0
            )
        )

    private val _events = MutableSharedFlow<PortalEvent>()
    val events = _events.asSharedFlow()

    fun onPortalClick() {
        viewModelScope.launch {
            if (state.value.portalCanBeOpened) {
                finishGameUseCase()
                _events.emit(PortalEvent.FINISH_GAME)
            } else {
                _events.emit(PortalEvent.SHOW_CLOSED_PORTAL)
            }
        }
    }
}

class PortalUiState(
    val portalCanBeOpened: Boolean,
    val remainingTime: Int
)

enum class PortalEvent {
    SHOW_CLOSED_PORTAL,
    FINISH_GAME
}
