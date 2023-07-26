package com.zenika.domain

import com.zenika.data.dao.ItemDao
import com.zenika.data.state.AdventureGameStateManager
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
        deleteAllItemsFromInventory()
    }

    private suspend fun deleteAllItemsFromInventory() {
        itemDao.deleteAll()
    }
}
