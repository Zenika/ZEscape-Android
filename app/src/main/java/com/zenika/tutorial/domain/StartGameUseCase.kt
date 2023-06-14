package com.zenika.tutorial.domain

import com.zenika.data.state.GameState
import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class StartGameUseCase @Inject constructor(
    private val initInventoryUseCase: InitInventoryUseCase,
    private val gameState: GameState,
    private val timerServiceManager: TimerServiceManager
) {
    suspend operator fun invoke() {
        initInventoryUseCase()
        gameState.initGame()
        timerServiceManager.startTimer()
    }
}
