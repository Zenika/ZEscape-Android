package com.zenika.story.adventure.domain

import com.zenika.R
import com.zenika.common.data.repository.ItemRepository
import com.zenika.story.adventure.data.AdventureGameStateManager
import javax.inject.Inject

class CollectMontrealKeyUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager,
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke() {
        gameStateManager.collectMontrealKey()
        itemRepository.addItem(itemName = "montrealKey", itemRes = R.mipmap.montreal_key)
    }
}
