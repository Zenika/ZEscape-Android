package com.zenika.tutorial.domain

import com.zenika.data.state.GameState
import javax.inject.Inject

class GetCurrentHintUseCase @Inject constructor(
    private val gameState: GameState
) {
    operator fun invoke() = gameState.currentHint
}
