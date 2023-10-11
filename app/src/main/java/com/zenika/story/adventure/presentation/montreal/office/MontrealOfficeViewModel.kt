package com.zenika.story.adventure.presentation.montreal.office

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.story.adventure.domain.CollectMontrealKeyUseCase
import com.zenika.story.adventure.domain.DiscoverMontrealOfficeUseCase
import com.zenika.story.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.story.adventure.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MontrealOfficeViewModel @Inject constructor(
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase,
    private val collectMontrealKey: CollectMontrealKeyUseCase,
    private val discoverMontrealOffice: DiscoverMontrealOfficeUseCase,
) : ViewModel() {
    val state: StateFlow<MontrealOfficeUiState> = combine(
        observeAdventureState(), observeRemainingTime()
    ) { gameState, remainingTime ->
        MontrealOfficeUiState(
            gameState.newItem,
            gameState.isMontrealKeyCollected,
            remainingTime
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = MontrealOfficeUiState(
            newItem = false,
            isMontrealKeyCollected = false,
            remainingTime = 0
        )
    )

    fun init() {
        discoverMontrealOffice()
    }

    fun collectKey() {
        viewModelScope.launch {
            collectMontrealKey()
        }
    }
}

class MontrealOfficeUiState(
    val newItem: Boolean,
    val isMontrealKeyCollected: Boolean,
    val remainingTime: Int
)
