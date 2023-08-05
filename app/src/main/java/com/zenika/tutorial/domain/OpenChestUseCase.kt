package com.zenika.tutorial.domain

import com.zenika.data.state.TutorialGameStateManager
import javax.inject.Inject

class OpenChestUseCase @Inject constructor(
    private val gameStateManager: TutorialGameStateManager
) {
    operator fun invoke() {
        gameStateManager.openChest()
    }
}