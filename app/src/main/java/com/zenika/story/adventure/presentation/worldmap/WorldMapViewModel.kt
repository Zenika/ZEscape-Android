package com.zenika.story.adventure.presentation.worldmap

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenika.story.adventure.domain.GetAgenciesUseCase
import com.zenika.story.adventure.domain.ObserveAdventureStateUseCase
import com.zenika.story.adventure.domain.model.Agency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WorldMapViewModel @Inject constructor(
    getAgencies: GetAgenciesUseCase,
    getAdventureState: ObserveAdventureStateUseCase
) : ViewModel() {
    val agencies: StateFlow<Set<Agency>> = getAgencies()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = setOf()
        )

    val state: StateFlow<AgenciesUiState> =
        getAdventureState().map { state ->
            AgenciesUiState(
                state.isSingaporeAgencyOpen,
                state.isCasablancaAgencyOpen,
                state.isMontrealAgencyOpen
            )
        }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = AgenciesUiState(
                    isSingaporeAgencyOpen = false,
                    isCasablancaAgencyOpen = false,
                    isMontrealAgencyOpen = false
                )
            )
}

class AgenciesUiState(
    val isSingaporeAgencyOpen: Boolean,
    val isCasablancaAgencyOpen: Boolean,
    val isMontrealAgencyOpen: Boolean
)
