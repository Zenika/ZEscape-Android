package com.zenika.data.state

import com.zenika.data.Agency
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AdventureGameStateManager @Inject constructor() {

    private val _state = MutableStateFlow(AdventureGameState())
    val state = _state.asStateFlow()

    fun initGame() {
        _state.update { AdventureGameState() }
    }

    fun addAgency(agency: Agency) {
        _state.update {
            it.copy(
                agencies = it.agencies + agency
            )
        }
    }
}