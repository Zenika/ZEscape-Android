package com.zenika.data.state

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

    private val _clueCount = MutableStateFlow(0)
    val clueCount = _clueCount.asStateFlow()

    private val _finalTimer = MutableStateFlow(0)
    val finalTimer = _finalTimer.asStateFlow()

    private val _newItem = MutableStateFlow(false)
    val newItem = _newItem.asStateFlow()

    private val _currentClue = MutableStateFlow("paperClue")
    val currentClue = _currentClue.asStateFlow()

    private val _clues = mapOf<String, Int>()
    var clues = _clues

    fun initGame() {
        _chestOpened.update { false }
        _keyCollected.update { false }
        _mapCollected.update { false }
        _newItem.update { false }
        _penaltyCount.update { 0 }
        _clueCount.update { 0 }
        _currentClue.update { "paperClue" }
    }

    fun openChest() {
        _chestOpened.update { true }
        _currentClue.update { "parchmentClue" }
    }

    fun collectKey() {
        _keyCollected.update { true }
        _newItem.update { true }
    }

    fun collectMap() {
        _mapCollected.update { true }
        _newItem.update { true }
    }

    fun removeNewItemBadge() {
        _newItem.update { false }
    }

    fun applyPenalty() {
        _penaltyCount.update { it + 1 }
    }

    fun incrementClueCount() {
        _clueCount.update { it + 1 }
    }

    fun updateFinalTimer(timer: Int) {
        _finalTimer.update { timer }
    }
}