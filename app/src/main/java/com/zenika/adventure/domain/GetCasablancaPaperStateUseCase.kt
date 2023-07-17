package com.zenika.adventure.domain

import com.zenika.data.state.AdventureGameStateManager
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCasablancaPaperStateUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke() = gameStateManager.state.map { it.casablancaPaperCollected }
}
