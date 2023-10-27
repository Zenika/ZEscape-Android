package com.zenika.story.adventure.domain

import com.zenika.story.adventure.data.AdventureGameStateManager
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveSafeStateUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke() = gameStateManager.state.map { it.isSafeOpen }
}
