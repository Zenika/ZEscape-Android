package com.zenika.adventure.presentation.casablanca.agency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.CollectCasablancaKeyUseCase
import com.zenika.adventure.domain.ObserveCasablancaKeyStateUseCase
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import com.zenika.adventure.domain.ObserveSafeStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CasablancaAgencyViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase,
    observeSafeStateUseCase: ObserveSafeStateUseCase,
    observeCasablancaKeyStateUseCase: ObserveCasablancaKeyStateUseCase,
    private val collectCasablancaKey: CollectCasablancaKeyUseCase
) : ViewModel() {
    val remainingTime: StateFlow<Int> =
        observeRemainingTime()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = 0
            )

    val safeState: StateFlow<CasablancaUiState> = combine(
        observeSafeStateUseCase(), observeCasablancaKeyStateUseCase()
    ) { safeState, keyState ->
        CasablancaUiState(
            isSafeOpen = safeState,
            isKeyCollected = keyState
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = CasablancaUiState(isSafeOpen = false, isKeyCollected = false)
        )

    fun collectKey() {
        viewModelScope.launch {
            collectCasablancaKey()
        }
    }
}

data class CasablancaUiState(
    val isSafeOpen: Boolean,
    val isKeyCollected: Boolean
)
