package com.zenika.adventure.domain

import com.zenika.data.state.AdventureGameStateManager
import javax.inject.Inject

class IncrementHintCountUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke() = gameStateManager.incrementHintCount()
}
