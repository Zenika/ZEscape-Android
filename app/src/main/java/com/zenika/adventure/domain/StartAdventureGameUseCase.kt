package com.zenika.adventure.domain

import com.zenika.data.dao.ItemDao
import com.zenika.data.state.GameStateManager
import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class StartAdventureGameUseCase @Inject constructor(
    private val itemDao: ItemDao,
    private val gameStateManager: GameStateManager,
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
