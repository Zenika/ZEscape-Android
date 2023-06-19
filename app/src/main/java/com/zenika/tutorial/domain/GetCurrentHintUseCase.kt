package com.zenika.tutorial.domain

import com.zenika.data.TutorialHint
import com.zenika.data.state.GameStateManager
import javax.inject.Inject

class GetCurrentHintUseCase @Inject constructor(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(): TutorialHint = gameStateManager.state.value.currentHint
}
