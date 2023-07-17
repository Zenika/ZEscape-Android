package com.zenika.tutorial.domain

import com.zenika.data.model.ItemDto
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

private fun List<ItemDto>.toInventory(): List<ItemDto> {
    if (this.size >= 10) {
        return this
    }
    return (this.size until 10).fold(this) { acc, _ ->
        acc + ItemDto(
            "",
            0
        )
    }
}

