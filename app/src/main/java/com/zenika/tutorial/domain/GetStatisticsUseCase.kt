package com.zenika.tutorial.domain

import com.zenika.data.state.GameState
import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class GetStatisticsUseCase @Inject constructor(
    private val timerServiceManager: TimerServiceManager,
    private val gameState: GameState
) {
    operator fun invoke(): Statistics {
        return Statistics(
            penalty = gameState.penaltyCount.value,
            hint = gameState.hintCount.value,
            elapsedTime = timerServiceManager.elapsed.value
        )
    }
}

class Statistics(
    val penalty: Int,
    val hint: Int,
    val elapsedTime: Int
)
