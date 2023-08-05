package com.zenika.tutorial.domain

import com.zenika.data.state.TutorialGameStateManager
import javax.inject.Inject

class UpdateGameStateUseCase @Inject constructor(
    private val gameStateManager: TutorialGameStateManager
) {

    fun removeNewItemBadge() {
        gameStateManager.removeNewItemBadge()
    }

    fun incrementHintCount() {
        gameStateManager.incrementHintCount()
    }
}
