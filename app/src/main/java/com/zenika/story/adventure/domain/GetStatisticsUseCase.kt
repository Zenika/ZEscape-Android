package com.zenika.story.adventure.domain

import com.zenika.story.adventure.data.AdventureGameStateManager
import com.zenika.common.data.timer.TimerServiceManager
import javax.inject.Inject

class GetStatisticsUseCase @Inject constructor(
    private val timerServiceManager: TimerServiceManager,
    private val gameStateManager: AdventureGameStateManager
) {
    operator fun invoke(): Statistics {
        return Statistics(
            penalty = gameStateManager.state.value.penaltyCount,
            hint = gameStateManager.state.value.hintCount,
            elapsedTime = timerServiceManager.elapsed.value
        )
    }
}

class Statistics(
    val penalty: Int,
    val hint: Int,
    val elapsedTime: Int
)
