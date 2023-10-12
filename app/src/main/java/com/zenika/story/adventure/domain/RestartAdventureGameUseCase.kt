package com.zenika.story.adventure.domain

import com.zenika.data.database.ItemDao
import com.zenika.story.adventure.data.AdventureGameStateManager
import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class RestartAdventureGameUseCase @Inject constructor(
    private val itemDao: ItemDao,
    private val gameStateManager: AdventureGameStateManager,
    private val timerServiceManager: TimerServiceManager
) {
    suspend operator fun invoke() {
        initInventory()
        gameStateManager.initGame()
        timerServiceManager.stopTimer()
        timerServiceManager.startTimer()
    }

    private suspend fun initInventory() {
        itemDao.deleteAll()
    }
}
