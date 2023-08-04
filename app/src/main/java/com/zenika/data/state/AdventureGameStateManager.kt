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
                isSingaporeKeyCollected = true,
                newItem = true
            )
        }
    }

    fun collectHook() {
        _state.update {
            it.copy(
                isHookCollected = true,
                newItem = true
            )
        }
    }

    fun collectSword() {
        _state.update {
            it.copy(
                isSwordCollected = true,
                newItem = true
            )
        }
    }

    fun removeNewItemBadge() {
        _state.update {
            it.copy(
                newItem = false
            )
        }
    }

    fun openCasablancaAgency() {
        _state.update {
            it.copy(
                isCasablancaAgencyOpen = true
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
                isCasablancaKeyCollected = true,
                newItem = true
            )
        }
    }

    fun collectCasablancaPaper() {
        _state.update {
            it.copy(
                isCasablancaPaperCollected = true,
                newItem = true
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

    fun openMontrealAgency() {
        _state.update {
            it.copy(
                isMontrealAgencyOpen = true
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

    fun openMontrealDoor() {
        _state.update {
            it.copy(
                isMontrealDoorOpen = true
            )
        }
    }

    fun discoverRooftop() {
        _state.update {
            it.copy(
                isRooftopDiscovered = true
            )
        }
    }

    fun discoverMeetingRoom() {
        _state.update {
            it.copy(
                isMeetingRoomDiscovered = true
            )
        }
    }
}
