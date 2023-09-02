package com.zenika.adventure.presentation.montreal.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import com.zenika.adventure.domain.RemoveNewItemBadgeUseCase
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
class LibraryViewModel @Inject constructor(
    observeAdventureState: ObserveAdventureStateUseCase,
    observeRemainingTime: ObserveRemainingTimeUseCase,
    private val removeNewItemBadgeUseCase: RemoveNewItemBadgeUseCase
) : ViewModel() {
    val state: StateFlow<MontrealLibraryUiState> = combine(
        observeAdventureState(),
        observeRemainingTime()
    ) { gameState, remainingTime ->
        MontrealLibraryUiState(
            newItem = gameState.newItem,
            remainingTime = remainingTime
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
        initialValue = MontrealLibraryUiState(newItem = false, remainingTime = 0)
    )

    private val _events = MutableSharedFlow<LibraryEvent>()
    val events = _events.asSharedFlow()

    fun openInventory() {
        viewModelScope.launch {
            removeNewItemBadgeUseCase()
            _events.emit(LibraryEvent.OPEN_INVENTORY)
        }
    }
}

class MontrealLibraryUiState(
    val newItem: Boolean,
    val remainingTime: Int
)

enum class LibraryEvent {
    OPEN_INVENTORY
}
