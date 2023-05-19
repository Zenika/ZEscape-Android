package com.zenika.data.repository

import com.zenika.R
import com.zenika.data.dao.ItemDao
import com.zenika.data.model.ItemDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val dao: ItemDao
) {
    fun getItems(): Flow<List<ItemDto>> = dao.getItems()

    suspend fun addItem(itemName: String, itemRes: Int) {
        val item = ItemDto(itemName, itemRes)
        dao.upsertItem(item)
    }

    suspend fun initInventory() {
        dao.deleteAll()
        val parchment = ItemDto("parchment", R.mipmap.parchment)
        dao.upsertItem(parchment)
        val paper = ItemDto("paper", R.mipmap.paper)
        dao.upsertItem(paper)
    }
}
