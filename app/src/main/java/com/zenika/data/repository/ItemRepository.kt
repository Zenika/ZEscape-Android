package com.zenika.data.repository

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
}
