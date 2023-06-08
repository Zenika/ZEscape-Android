package com.zenika.tutorial.domain

import com.zenika.R
import com.zenika.data.state.GameState
import javax.inject.Inject

class InitCluesUseCase @Inject constructor(
    private val gameState: GameState
) {
    operator fun invoke() {
        gameState.clues = mapOf(
            "paperClue" to R.string.paperClue,
            "parchmentClue" to R.string.parchmentClue
        )
    }
}
