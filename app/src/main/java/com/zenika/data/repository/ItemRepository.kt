package com.zenika.data.repository

import com.zenika.data.database.ItemDao
import com.zenika.data.entity.ItemEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val dao: ItemDao
) {
    fun observeItems(): Flow<List<ItemEntity>> = dao.observeItems()

    suspend fun addItem(itemName: String, itemRes: Int) {
        val item = ItemEntity(itemName, itemRes)
        dao.upsertItem(item)
    }

    suspend fun deleteItem(itemName: String, itemRes: Int) {
        val item = ItemEntity(itemName, itemRes)
        dao.deleteItem(item)
    }
}
