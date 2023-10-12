package com.zenika.story.adventure.domain

import com.zenika.R
import com.zenika.data.repository.ItemRepository
import com.zenika.story.adventure.data.AdventureGameStateManager
import javax.inject.Inject

class CollectCasablancaKeyUseCase @Inject constructor(
    private val gameStateManager: AdventureGameStateManager,
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke() {
        itemRepository.addItem("casablancaKey", R.mipmap.casablanca_key)
        gameStateManager.collectCasablancaKey()
    }
}
