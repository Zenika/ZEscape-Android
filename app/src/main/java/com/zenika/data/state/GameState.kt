package com.zenika.data.state

import com.zenika.data.TutorialHint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameState @Inject constructor() {
    private val _chestOpened = MutableStateFlow(false)
    val chestOpened = _chestOpened.asStateFlow()

    private val _keyCollected = MutableStateFlow(false)
    val keyCollected = _keyCollected.asStateFlow()

    private val _mapCollected = MutableStateFlow(false)
    val mapCollected = _mapCollected.asStateFlow()

    private val _penaltyCount = MutableStateFlow(0)
    val penaltyCount = _penaltyCount.asStateFlow()

    private val _hintCount = MutableStateFlow(0)
    val hintCount = _hintCount.asStateFlow()

    private val _newItem = MutableStateFlow(false)
    val newItem = _newItem.asStateFlow()

    private val _currentHint = MutableStateFlow(TutorialHint.CAPTAIN_CHEST)
    val currentHint = _currentHint.asStateFlow()

    fun initGame() {
        _chestOpened.update { false }
        _keyCollected.update { false }
        _mapCollected.update { false }
        _newItem.update { false }
        _penaltyCount.update { 0 }
        _hintCount.update { 0 }
        _currentHint.update { TutorialHint.CAPTAIN_CHEST }
    }

    fun openChest() {
        _chestOpened.update { true }
        _currentHint.update { TutorialHint.END_GAME }
    }

    fun collectKey() {
        _keyCollected.update { true }
        _newItem.update { true }
    }

    fun collectMap() {
        _mapCollected.update { true }
        _newItem.update { true }
        _currentHint.update { TutorialHint.END_GAME }
    }

    fun removeNewItemBadge() {
        _newItem.update { false }
    }

    fun applyPenalty() {
        _penaltyCount.update { it + 1 }
    }

    fun incrementClueCount() {
        _hintCount.update { it + 1 }
    }
}