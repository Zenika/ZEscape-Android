package com.zenika.tutorial.domain

import com.zenika.data.state.GameState
import javax.inject.Inject

class UpdateGameStateUseCase @Inject constructor(
    private val gameState: GameState
) {
    fun openChest() {
        gameState.openChest()
    }

    fun collectKey() {
        gameState.collectKey()
    }

    fun collectMap() {
        gameState.collectMap()
    }

    fun removeNewItemBadge() {
        gameState.removeNewItemBadge()
    }

    fun incrementClueCount() {
        gameState.incrementClueCount()
    }
}
