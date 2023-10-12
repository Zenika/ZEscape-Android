package com.zenika.story.adventure.domain

import com.zenika.R
import com.zenika.common.data.repository.ItemRepository
import com.zenika.story.adventure.data.AdventureGameStateManager
import javax.inject.Inject

class CollectHookUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager,
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke() {
        gameStateManager.collectHook()
        itemRepository.addItem(itemName = "hook", itemRes = R.mipmap.hook)
    }
}
