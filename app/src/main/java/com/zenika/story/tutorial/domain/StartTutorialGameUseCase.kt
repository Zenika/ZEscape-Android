package com.zenika.story.tutorial.domain

import com.zenika.R
import com.zenika.data.database.ItemDao
import com.zenika.data.entity.ItemEntity
import com.zenika.data.state.TutorialGameStateManager
import com.zenika.data.timer.TimerServiceManager
import javax.inject.Inject

class StartTutorialGameUseCase @Inject constructor(
    private val itemDao: ItemDao,
    private val gameStateManager: TutorialGameStateManager,
    private val timerServiceManager: TimerServiceManager
) {
    suspend operator fun invoke() {
        initInventory()
        gameStateManager.initGame()
        timerServiceManager.startTimer()
    }

    private suspend fun initInventory() {
        deleteAllItemsFromInventory()
        addInitialItemsToInventory()
    }

    private suspend fun deleteAllItemsFromInventory() {
        itemDao.deleteAll()
    }

    private suspend fun addInitialItemsToInventory() {
        val parchment = ItemEntity("parchment", R.mipmap.parchment)
        itemDao.upsertItem(parchment)
        val paper = ItemEntity("paper", R.mipmap.paper)
        itemDao.upsertItem(paper)
    }

}
