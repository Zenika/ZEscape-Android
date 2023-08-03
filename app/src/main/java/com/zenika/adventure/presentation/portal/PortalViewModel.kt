package com.zenika.adventure.presentation.portal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.FinishGameUseCase
import com.zenika.adventure.domain.ObserveKeyCollectionUseCase
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

    fun finishGame() {
        finishGameUseCase()
    }
}

class PortalUiState(
    val portalCanBeOpened: Boolean,
    val remainingTime: Int
)
