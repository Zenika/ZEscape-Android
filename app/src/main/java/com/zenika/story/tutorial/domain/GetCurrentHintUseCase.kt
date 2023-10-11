package com.zenika.story.tutorial.domain

import com.zenika.data.state.TutorialGameStateManager
import com.zenika.story.tutorial.domain.model.TutorialHint
import javax.inject.Inject

class GetCurrentHintUseCase @Inject constructor(
    private val gameStateManager: TutorialGameStateManager
) {
    operator fun invoke(): TutorialHint = gameStateManager.state.value.currentHint
}
