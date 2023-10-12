package com.zenika.common.domain

import com.zenika.data.entity.ItemEntity
import com.zenika.data.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveInventoryUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    operator fun invoke(): Flow<Inventory> = itemRepository.observeItems()
        .map { items -> items.toInventory() }
        .flowOn(Dispatchers.Default)
}

private fun List<ItemEntity>.toInventory(): Inventory {
    if (this.size >= 10) {
        return Inventory(this)
    }

    val paddedItems = (this.size until 10).fold(this) { acc, _ ->
        acc + ItemEntity.EMPTY
    }

    return Inventory(paddedItems)
}

class Inventory(
    val items: List<ItemEntity>
) {
    companion object {
        fun start(): Inventory = Inventory(listOf())
    }
}
