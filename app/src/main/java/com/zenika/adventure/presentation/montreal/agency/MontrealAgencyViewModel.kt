package com.zenika.adventure.presentation.montreal.agency

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ObserveRemainingTimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MontrealAgencyViewModel @Inject constructor(
    observeRemainingTime: ObserveRemainingTimeUseCase
) : ViewModel() {
    val remainingTime: StateFlow<Int> = observeRemainingTime()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = 0
        )
}
