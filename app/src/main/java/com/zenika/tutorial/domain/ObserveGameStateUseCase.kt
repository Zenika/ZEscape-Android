package com.zenika.tutorial.domain

import com.zenika.data.state.GameState
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class ObserveGameStateUseCase @Inject constructor(
    private val gameState: GameState,
    private val observeRemainingTimeUseCase: ObserveRemainingTimeUseCase
) {
    operator fun invoke() =
        combine(
            gameState.chestOpened,
            gameState.mapCollected,
            gameState.keyCollected,
            gameState.newItem,
            observeRemainingTimeUseCase()
        ) { chestOpened, mapCollected, keyCollected, newItem, remainingTime ->
            GameUIState(chestOpened, mapCollected, keyCollected, newItem, remainingTime)
        }
}

class GameUIState(
    val chestOpened: Boolean,
    val mapCollected: Boolean,
    val keyCollected: Boolean,
    val newItem: Boolean,
    val remainingTime: Int
)