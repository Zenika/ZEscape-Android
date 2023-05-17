package com.zenika.tutorial.domain

import com.zenika.data.repository.ItemRepository
import javax.inject.Inject

class InitInventoryUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke() {
        itemRepository.initInventory()
    }
}