package com.zenika.tutorial.domain

import com.zenika.data.TutorialHint
import com.zenika.data.state.TutorialGameStateManager
import javax.inject.Inject

class GetCurrentHintUseCase @Inject constructor(
    private val gameStateManager: TutorialGameStateManager
) {
    operator fun invoke(): TutorialHint = gameStateManager.state.value.currentHint
}
