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

    fun openSingaporeAgency() {
        _state.update {
            it.copy(
                isSingaporeAgencyOpen = true
            )
        }
    }

    fun collectSingaporeKey() {
        _state.update {
            it.copy(
                isSingaporeKeyCollected = true
            )
        }
    }

    fun collectHook() {
        _state.update {
            it.copy(
                isHookCollected = true
            )
        }
    }

    fun collectSword() {
        _state.update {
            it.copy(
                isSwordCollected = true
            )
        }
    }

    fun openSafe() {
        _state.update {
            it.copy(
                isSafeOpen = true
            )
        }
    }

    fun collectCasablancaKey() {
        _state.update {
            it.copy(
                isCasablancaKeyCollected = true
            )
        }
    }

    fun collectCasablancaPaper() {
        _state.update {
            it.copy(
                isCasablancaPaperCollected = true
            )
        }
    }

    fun applyPenalty() {
        _state.update {
            it.copy(
                penaltyCount = it.penaltyCount + 1
            )
        }
    }

    fun incrementHintCount() {
        _state.update {
            it.copy(
                hintCount = it.hintCount + 1
            )
        }
    }
}

