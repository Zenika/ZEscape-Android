package com.zenika.adventure.domain

import com.zenika.data.repository.ItemRepository
import javax.inject.Inject

class RemoveItemFromInventoryUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke(item: String, itemRes: Int) {
        itemRepository.deleteItem(item, itemRes)
    }
}
