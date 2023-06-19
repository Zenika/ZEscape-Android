package com.zenika.tutorial.domain

import com.zenika.data.state.GameStateManager
import javax.inject.Inject

class UpdateGameStateUseCase @Inject constructor(
    private val gameStateManager: GameStateManager
) {
    fun openChest() {
        gameStateManager.openChest()
    }

    fun collectKey() {
        gameStateManager.collectKey()
    }

    fun collectMap() {
        gameStateManager.collectMap()
    }

    fun removeNewItemBadge() {
        gameStateManager.removeNewItemBadge()
    }

    fun incrementClueCount() {
        gameStateManager.incrementClueCount()
    }
}
