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

    private val _mapCollected = MutableStateFlow(false)
    val mapCollected = _mapCollected.asStateFlow()

    fun openChest() {
        _chestOpened.update { true }
    }

    fun collectMap() {
        _mapCollected.update { true }
    }
}