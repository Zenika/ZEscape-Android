package com.zenika.story.adventure.domain

import com.zenika.R
import com.zenika.common.data.repository.ItemRepository
import com.zenika.story.adventure.data.AdventureGameStateManager
import javax.inject.Inject

class CollectCasablancaPaperUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager,
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke() {
        gameStateManager.collectCasablancaPaper()
        itemRepository.addItem("casablancaPaper", R.mipmap.casablanca_code)
    }
}
