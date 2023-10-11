package com.zenika.story.tutorial.domain

import com.zenika.data.state.TutorialGameStateManager
import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class GetStatisticsUseCase @Inject constructor(
    private val timerServiceManager: TimerServiceManager,
    private val gameStateManager: TutorialGameStateManager
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
