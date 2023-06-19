package com.zenika.tutorial.domain

import com.zenika.data.state.GameStateManager
import javax.inject.Inject

class ApplyPenaltyUseCase @Inject constructor(
    private val gameStateManager: GameStateManager
) {
    operator fun invoke() {
        gameStateManager.applyPenalty()
    }
}
