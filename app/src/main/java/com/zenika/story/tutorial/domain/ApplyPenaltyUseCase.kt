package com.zenika.story.tutorial.domain

import com.zenika.story.tutorial.data.TutorialGameStateManager
import javax.inject.Inject

class ApplyPenaltyUseCase @Inject constructor(
    private val gameStateManager: TutorialGameStateManager
) {
    operator fun invoke() {
        gameStateManager.applyPenalty()
    }
}
