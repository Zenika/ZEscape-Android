package com.zenika.tutorial.domain

import com.zenika.data.model.ItemDto
import com.zenika.data.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class addItemsToInventoryUseCase(
    private val itemRepository: ItemRepository
) {
    suspend fun getItems(): Flow<List<ItemDto>> {
        val items = itemRepository.getItems()
        val i = items.collect()
        return items
    }
}