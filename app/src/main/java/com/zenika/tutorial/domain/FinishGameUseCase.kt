package com.zenika.tutorial.domain

import com.zenika.data.state.GameState
import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class FinishGameUseCase @Inject constructor(
    private val timerServiceManager: TimerServiceManager,
    private val gameState: GameState
) {
    operator fun invoke() {
        val timer = timerServiceManager.getTimer()
        gameState.updateFinalTimer(timer)
        timerServiceManager.stopTimer()
    }
}
