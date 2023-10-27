package com.zenika.story.adventure.presentation.portal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.story.adventure.domain.FinishGameUseCase
import com.zenika.story.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.story.adventure.domain.ObserveKeyCollectionUseCase
import com.zenika.story.adventure.domain.ObserveRemainingTimeUseCase
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
    observeAdventureState: ObserveAdventureStateUseCase,
    private val finishGameUseCase: FinishGameUseCase
) : ViewModel() {

    private val _events = MutableSharedFlow<PortalEvent>()
    val events = _events.asSharedFlow()

    val state: StateFlow<PortalUiState> = combine(
        observeKeyCollection(),
        observeAdventureState(),
        observeRemainingTime()
    ) { keyCollection, gameState, remainingTime ->
        PortalUiState(
            portalCanBeOpened = keyCollection.isSingaporeKeyCollected
                && keyCollection.isCasablancaKeyCollected
                && keyCollection.isMontrealKeyCollected,
            newItem = gameState.newItem,
            remainingTime = remainingTime
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = PortalUiState(
            portalCanBeOpened = false,
            newItem = false,
            remainingTime = 0
        )
    )

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
    val newItem: Boolean,
    val remainingTime: Int
)

enum class PortalEvent {
    SHOW_CLOSED_PORTAL,
    FINISH_GAME
}
