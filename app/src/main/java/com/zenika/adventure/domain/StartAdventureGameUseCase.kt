package com.zenika.adventure.domain

import com.zenika.data.dao.ItemDao
import com.zenika.data.state.AdventureGameStateManager
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
        deleteAll()
    }

    private suspend fun deleteAll() {
        itemDao.deleteAll()
    }
}
