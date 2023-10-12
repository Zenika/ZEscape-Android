package com.zenika.story.tutorial.domain

import com.zenika.story.tutorial.data.TutorialGameStateManager
import javax.inject.Inject

class ShowHintUseCase @Inject constructor(
    private val gameStateManager: TutorialGameStateManager
) {
    operator fun invoke() {
        gameStateManager.incrementHintCount()
    }
}
