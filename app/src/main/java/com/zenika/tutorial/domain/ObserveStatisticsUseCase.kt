package com.zenika.tutorial.domain

import com.zenika.data.state.GameState
import javax.inject.Inject

class ObserveStatisticsUseCase @Inject constructor(
    private val observeRemainingTimeUseCase: ObserveRemainingTimeUseCase,
    private val gameState: GameState
) {
    operator fun invoke(): StatisticsUIState {
        val remainingTime = observeRemainingTimeUseCase()
        val finalTimer = 3600000 - remainingTime.value
        return StatisticsUIState(
            gameState.penaltyCount.value,
            gameState.hintCount.value,
            finalTimer
        )
    }
}

class StatisticsUIState(
    val penalty: Int,
    val hint: Int,
    val finalTimer: Int
)