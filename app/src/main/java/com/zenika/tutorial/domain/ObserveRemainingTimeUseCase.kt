package com.zenika.tutorial.domain

import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class ObserveRemainingTimeUseCase @Inject constructor(
    private val timerServiceManager: TimerServiceManager
) {
    operator fun invoke() = timerServiceManager.remaining
}