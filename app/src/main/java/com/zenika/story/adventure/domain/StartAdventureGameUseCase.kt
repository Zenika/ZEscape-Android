package com.zenika.story.adventure.domain

import com.zenika.data.database.ItemDao
import com.zenika.story.adventure.data.AdventureGameStateManager
import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class StartAdventureGameUseCase @Inject constructor(
    private val itemDao: ItemDao,
    private val gameStateManager: AdventureGameStateManager,
    private val timerServiceManager: TimerServiceManager
) {
    suspend operator fun invoke() {
        initInventory()
        gameStateManager.initGame()
        timerServiceManager.startTimer()
    }

    private suspend fun initInventory() {
        deleteAllItemsFromInventory()
    }

    private suspend fun deleteAllItemsFromInventory() {
        itemDao.deleteAll()
    }
}
