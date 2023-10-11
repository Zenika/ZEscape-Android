package com.zenika.story.adventure.domain

import com.zenika.data.entity.ItemEntity
import com.zenika.data.repository.ItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveInventoryUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    operator fun invoke() = itemRepository.observeItems()
        .map { items -> items.toInventory() }
        .flowOn(Dispatchers.Default)
}

private fun List<ItemEntity>.toInventory(): List<ItemEntity> {
    if (this.size >= 10) {
        return this
    }
    return (this.size until 10).fold(this) { acc, _ ->
        acc + ItemEntity(
            "",
            0
        )
    }
}
