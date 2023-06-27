package com.zenika.adventure.domain

import com.zenika.data.state.AdventureGameStateManager
import javax.inject.Inject

class CollectHookUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke() = gameStateManager.collectHook()
}
