package com.zenika.story.tutorial.domain

import com.zenika.R
import com.zenika.common.data.repository.ItemRepository
import com.zenika.story.tutorial.data.TutorialGameStateManager
import javax.inject.Inject

class CollectKeyUseCase @Inject constructor(
    private val gameStateManager: TutorialGameStateManager,
    private val itemRepository: ItemRepository,
) {
    suspend operator fun invoke() {
        gameStateManager.collectKey()
        itemRepository.addItem("key", R.mipmap.key)
    }
}
