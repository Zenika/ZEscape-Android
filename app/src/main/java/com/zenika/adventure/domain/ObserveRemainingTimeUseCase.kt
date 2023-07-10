package com.zenika.adventure.domain

import com.zenika.data.state.GameStateManager
import com.zenika.data.timer.TimerServiceManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

private const val TOTAL_TIME_MS = 3_600_000
private const val PENALTY_IN_MS = 60_000
class ObserveRemainingTimeUseCase @Inject constructor(
    private val timerServiceManager: TimerServiceManager,
    private val gameStateManager: GameStateManager
) {
    operator fun invoke(): Flow<Int> {
        return combine(
            timerServiceManager.elapsed,
            gameStateManager.state
        ) { elapsedMs, tutorialGameState ->
            TOTAL_TIME_MS - elapsedMs - (tutorialGameState.penaltyCount * PENALTY_IN_MS)
        }
    }
}