package com.zenika.tutorial.domain

import com.zenika.data.state.TutorialGameStateManager
import javax.inject.Inject

class UpdateGameStateUseCase @Inject constructor(
    private val gameStateManager: TutorialGameStateManager
) {
    fun openChest() {
        gameStateManager.openChest()
    }

    fun removeNewItemBadge() {
        gameStateManager.removeNewItemBadge()
    }

    fun incrementHintCount() {
        gameStateManager.incrementHintCount()
    }
}
