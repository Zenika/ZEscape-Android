package com.zenika.data.state

import com.zenika.data.TutorialHint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TutorialGameStateManager @Inject constructor() {

    private val _state = MutableStateFlow(TutorialGameState())
    val state = _state.asStateFlow()

    fun initGame() {
        _state.update { TutorialGameState() }
    }

    fun openChest() {
        _state.update {
            it.copy(
                chestOpened = true,
                currentHint = TutorialHint.END_GAME
            )
        }
    }

    fun collectKey() {
        _state.update {
            it.copy(
                keyCollected = true,
                newItem = true
            )
        }
    }

    fun collectMap() {
        _state.update {
            it.copy(
                mapCollected = true,
                newItem = true,
                currentHint = TutorialHint.END_GAME
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
