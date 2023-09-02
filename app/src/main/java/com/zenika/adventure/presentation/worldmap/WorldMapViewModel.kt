package com.zenika.adventure.presentation.worldmap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.adventure.domain.GetAdventureStateUseCase
import com.zenika.adventure.domain.GetAgenciesUseCase
import com.zenika.data.Agency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WorldMapViewModel @Inject constructor(
    getAgencies: GetAgenciesUseCase,
    getAdventureState: GetAdventureStateUseCase
) : ViewModel() {
    val agencies: StateFlow<Set<Agency>> = getAgencies()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = setOf()
        )

    val isSingaporeAgencyOpen: StateFlow<Boolean> =
        getAdventureState().map { state -> state.isSingaporeAgencyOpen }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = false
            )
}
