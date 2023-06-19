package com.zenika.tutorial.domain

import com.zenika.R
import com.zenika.data.dao.ItemDao
import com.zenika.data.model.ItemDto
import com.zenika.data.state.GameStateManager
import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class StartGameUseCase @Inject constructor(
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
        deleteAll()
        upsertInitialItems()
    }

    private suspend fun deleteAll() {
        itemDao.deleteAll()
    }

    private suspend fun upsertInitialItems() {
        val parchment = ItemDto("parchment", R.mipmap.parchment)
        itemDao.upsertItem(parchment)
        val paper = ItemDto("paper", R.mipmap.paper)
        itemDao.upsertItem(paper)
    }

}
