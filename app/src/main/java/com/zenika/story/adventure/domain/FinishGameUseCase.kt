package com.zenika.story.adventure.domain

import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class FinishGameUseCase @Inject constructor(
    private val timerServiceManager: TimerServiceManager
) {
    operator fun invoke() {
        timerServiceManager.stopTimer()
    }
}
