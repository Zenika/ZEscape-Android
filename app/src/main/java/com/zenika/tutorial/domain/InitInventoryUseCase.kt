package com.zenika.tutorial.domain

import com.zenika.R
import com.zenika.data.dao.ItemDao
import com.zenika.data.model.ItemDto
import javax.inject.Inject

class InitInventoryUseCase @Inject constructor(
    private val itemDao: ItemDao
) {
    suspend operator fun invoke() {
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
