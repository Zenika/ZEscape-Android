package com.zenika.story.adventure.domain

import com.zenika.R
import com.zenika.data.repository.ItemRepository
import com.zenika.story.adventure.data.AdventureGameStateManager
import javax.inject.Inject

class CollectSwordUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager,
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke() {
        gameStateManager.collectSword()
        itemRepository.addItem(itemName = "sword", itemRes = R.mipmap.sword)
    }
}
