package com.zenika.tutorial.domain

import com.zenika.data.state.GameStateManager
import javax.inject.Inject

class ObserveTutorialStateUseCase @Inject constructor(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke() = gameStateManager.state
}
