package com.zenika.story.tutorial.domain

import com.zenika.common.data.timer.TimerServiceManager
import javax.inject.Inject

class FinishGameUseCase @Inject constructor(
    private val timerServiceManager: TimerServiceManager
) {
    operator fun invoke() {
        timerServiceManager.stopTimer()
    }
}
