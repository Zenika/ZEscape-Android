package com.zenika.adventure.presentation.world_map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.ObserveAgenciesUseCase
import com.zenika.data.Agency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WorldMapViewModel @Inject constructor(
    observeAgencies: ObserveAgenciesUseCase
) : ViewModel() {
    val agencies: StateFlow<Set<Agency>> = observeAgencies().map { state -> state.agencies }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = setOf()
        )
}
