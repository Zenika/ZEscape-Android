package com.zenika.story.adventure.domain

import com.zenika.story.adventure.data.AdventureGameStateManager
import javax.inject.Inject

class OpenSafeUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke() = gameStateManager.openSafe()
}
