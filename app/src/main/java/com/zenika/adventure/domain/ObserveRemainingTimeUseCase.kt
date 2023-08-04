package com.zenika.adventure.domain

import com.zenika.data.state.AdventureGameStateManager
import com.zenika.data.timer.TimerServiceManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

private const val TOTAL_TIME_MS = 1_800_000
private const val PENALTY_IN_MS = 60_000

class ObserveRemainingTimeUseCase @Inject constructor(
    private val timerServiceManager: TimerServiceManager,
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke(): Flow<Int> {
        return combine(
            timerServiceManager.elapsed,
            gameStateManager.state
        ) { elapsedMs, adventureGameState ->
            TOTAL_TIME_MS - elapsedMs - (adventureGameState.penaltyCount * PENALTY_IN_MS)
        }
    }
}
