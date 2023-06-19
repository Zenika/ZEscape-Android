package com.zenika.tutorial.domain

import com.zenika.data.state.GameState
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class ObserveMainGameStateUseCase @Inject constructor(
    private val gameState: GameState
) {
    operator fun invoke() =
        combine(
            gameState.chestOpened,
            gameState.mapCollected,
            gameState.keyCollected,
            gameState.newItem
        ) { chestOpened, mapCollected, keyCollected, newItem ->
            MainGameState(chestOpened, mapCollected, keyCollected, newItem)
        }
}

class MainGameState(
    val chestOpened: Boolean,
    val mapCollected: Boolean,
    val keyCollected: Boolean,
    val newItem: Boolean
)